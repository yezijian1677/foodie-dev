package com.imooc.controller.center;

import com.imooc.center.bo.CenterUserBO;
import com.imooc.controller.BaseController;
import com.imooc.pojo.Users;
import com.imooc.resources.FileUpload;
import com.imooc.service.center.CenterUserService;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.JsonUtils;
import com.imooc.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author augenye
 * @date 2019/11/15 7:47 下午
 */
@Api(value = "用户信息接口", tags = {"用户信息接口"})
@RestController
@RequestMapping("userInfo")
public class CenterUserController extends BaseController {

    @Autowired
    private FileUpload fileUpload;
    @Autowired
    private CenterUserService centerUserService;


    @ApiOperation(value = "用户头像更改", notes = "用户头像更改", httpMethod = "POST")
    @PostMapping("uploadFace")
    public Result uploadFace(@ApiParam(name = "userId", value = "用户id", required = true) @RequestParam String userId,
                         @ApiParam(name = "file", value = "用户头像", required = true) MultipartFile file,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        //定义头像的保存地址
//        String fileSpace = IMAGE_USER_FACE_LOCATION;
        String fileSpace = fileUpload.getImageUserFaceLocation();
        //在路径上为每一个用户增加一个userId，用于区分不同用户上传
        String uploadPathPrefix = File.separator + userId;

        //开始文件上传
        if (file != null) {
            //文件上传的上传名称
            String fileName = file.getOriginalFilename();
            if (StringUtils.isNoneBlank(fileName)) {
                //face-{userId}.png
                String[] fileNameArr = fileName.split("\\.");
                //获取文件的后缀名
                String suffix = fileNameArr[fileNameArr.length - 1];
                //文件名称重组 会覆盖上传, 增量的话应当拼接当前时间
                String newFileName = "face-" + userId + "." + suffix;
                //上传的头像最终的保存的位置
                String finalFacePath = fileSpace + uploadPathPrefix + File.separator + newFileName;

                File outFile = new File(finalFacePath);
                if (outFile.getParentFile() != null) {
                    //创建文件夹, 递归生成多级
                    outFile.getParentFile().mkdirs();
                }
                //文件输出保存到目录
                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = new FileOutputStream(outFile);
                    InputStream inputStream = file.getInputStream();
                    //使用apache下的包文件拷贝
                    IOUtils.copy(inputStream, fileOutputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            return Result.errorMsg("文件不能为空");
        }

        return Result.ok();
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息", httpMethod = "POST")
    @PostMapping("update")
    public Result update(@ApiParam(name = "userId", value = "用户id", required = true) @RequestParam String userId,
                         @ApiParam(name = "用户BO", value = "用户BO", required = true) @RequestBody @Valid CenterUserBO centerUserBO,
                         BindingResult result,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        // 判断result是否包含错误的验证信息
        if (result.hasErrors()) {
            Map<String, String> errorMap = getErrors(result);
            return Result.errorMap(errorMap);
        }
        Users userResult = centerUserService.updateUserInfo(userId, centerUserBO);

        userResult = setNullProperty(userResult);

        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userResult), true);

        //TODO 后需要改， 增加令牌token，整合redis
        return Result.ok();
    }

    private Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<>();
        List<FieldError> list = result.getFieldErrors();
        for (FieldError error : list) {
            //发生验证错误所对应的某一个属性
            String errorField = error.getField();
            //验证错误的信息
            String errorMsg = error.getDefaultMessage();
            map.put(errorField, errorMsg);
        }

        return map;
    }

    private Users setNullProperty(Users result) {
        result.setPassword(null);
        result.setMobile(null);
        result.setEmail(null);
        result.setCreatedTime(null);
        result.setUpdatedTime(null);
        result.setBirthday(null);

        return result;
    }
}
