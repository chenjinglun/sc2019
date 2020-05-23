package com.xzsd.pc.image.controller;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.image.service.ImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/imageUpLoad")
public class ImageController {
    @Resource
    private ImageService imageService;
    @ResponseBody
    /**
     * 上传图片
     */
    @PostMapping("upLoadImage")
    public AppResponse upLoadImage(@RequestParam("imageFile") MultipartFile uploadFile) throws IOException {
        try {
            return imageService.upLoadImage(uploadFile);
        } catch (Exception e) {
            throw e;
        }
    }
}
