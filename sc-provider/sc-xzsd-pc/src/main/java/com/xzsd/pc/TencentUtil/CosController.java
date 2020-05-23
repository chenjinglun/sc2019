//package com.xzsd.pc.TencentUtil;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import java.io.File;
//import java.util.Map;
//
///**
// * @author scout
// * @date 2020年4月20日21:36:48
// */
//@Controller
//public class CosController {
//    /**
//     * 把文件上传到腾讯云存储服务器
//     * @param multfile
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/uploadImage")
//    public String upload(@RequestParam("file") MultipartFile multfile,Map<String,Object> map)throws Exception{
//        // 获取文件名
//        String fileName = multfile.getOriginalFilename();
//        // 获取文件后缀
//        String prefix=fileName.substring(fileName.lastIndexOf("."));
//        // 用uuid作为文件名，防止生成的临时文件重复
//        final File excelFile = File.createTempFile("imagesFile-"+System.currentTimeMillis(), prefix);
//        // 将MultipartFile转为File
//        multfile.transferTo(excelFile);
//
//        //调用腾讯云工具上传文件
//         fileName = TencentCOS.uploadfile(excelFile);
//
//        //程序结束时，删除临时文件
//        deleteFile(excelFile);
//        //存入图片名称，用于网页显示
//        map.put("imageName",fileName);
//        //返回图片名称
//        return "index";
//    }
//
//    /**
//     * 删除临时文件
//     * @param files
//     */
//    private void deleteFile(File... files) {
//        for (File file : files) {
//            if (file.exists()) {
//                file.delete();
//            }
//        }
//    }
//}
