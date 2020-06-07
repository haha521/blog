package com.hanyuebb.blog.controller;

import com.hanyuebb.blog.common.result.BaseResult;
import com.hanyuebb.blog.common.result.BaseResultBulider;
import com.hanyuebb.blog.common.result.ResultCode;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
/**
 * ClassName:UploadController
 * Package:com.hanyuebb.blog.controller
 * Description:
 *
 * @date:2020/1/30 22:22
 * @auther:zh
 */
@RestController
@RequestMapping("/file")
public class UploadController {

    /**
     * @description 文件上传接口
     * @author YangHao
     * @time 2018年12月12日-下午10:17:53
     * @param file
     * @return
     */
    @RequestMapping("/fileUpload")
    @ApiOperation(value = "图片上传接口", notes = "")
    @ResponseBody
    public BaseResult<String> fileUpload(@RequestParam("fileData") MultipartFile file) {
// 获取原始名字
        String fileName = file.getOriginalFilename();
        // 获取后缀名
        // String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件保存路径
        String filePath = "/upload/";
        // 文件重命名，防止重复
        fileName = filePath + System.currentTimeMillis()+"/"+ fileName;
        // 文件对象
        File dest = new File(fileName);
        // 判断路径是否存在，如果不存在则创建
        if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            // 保存到服务器中
            file.transferTo(dest);
            return BaseResultBulider.success(fileName, ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BaseResultBulider.faile(ResultCode.SYSTEM_INNER_ERROR);
    }

    /**
     * @description 显示原文件（图片）
     * @author YangHao
     * @date 2018年9月3日-下午10:46:18
     * @param path
     * @param response
     */
    @ApiOperation(value = "显示原文件（图片）", notes = "")
    @ApiImplicitParam(name = "path", value = "服务器图片路径", required = true, dataType = "String")
    @GetMapping(value = "/getImg")
    public void getImg(String path, HttpServletResponse response) {
        if(StringUtils.isNotBlank(path)) {
            // 输入输出流
            FileInputStream fis = null;
            OutputStream os = null;
            // 组织完整的文件路径
            try {
                // File file = new File(url);
                fis = new FileInputStream(path);
                os = response.getOutputStream();
                int count = 0;
                byte[] buffer = new byte[1024 * 8];
                while ((count = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, count);
                    os.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @description 显示图片的缩略图 使用thumbnailator插件
     * @author YangHao
     * @date 2018年9月3日-下午10:46:44
     * @param path:路径
     * @param wh：1.不传入，使用默认的100px*100px;2.只传入高度，格式：200，高度根据比例得出;3.宽和高都传入格式：100-100
     * @param response
     */
    @ApiOperation(value = "显示图片的缩略图，根据传入宽高拉伸", notes = "")
    @ApiImplicitParams({ @ApiImplicitParam(name = "path", value = "服务器图片路径", required = true, dataType = "String"),
            @ApiImplicitParam(name = "wh", value = "想要获取图片的宽高 格式：100-100", required = false, dataType = "String") })
    @GetMapping(value = "/thumbImg")
    public void thumbImg(String path, String wh, HttpServletResponse response) {
        if(StringUtils.isNotBlank(path)) {
            // 缩略图
            BufferedImage thumbnail = null;
            // 需要压缩的尺寸，默认
            Integer width = 120;
            Integer height = 120;
            // 组织完整的文件路径
            try {

                // 获取原尺寸的图片
                BufferedImage image = ImageIO.read(new FileInputStream(path));
                // 读取原始图片的宽高
                Integer widthOrig = image.getWidth();
                Integer heightOrig = image.getHeight();

                // 判断是否传入了需要压缩的尺寸
                if (wh == null || // 没有传入压缩尺寸
                        (StringUtils.isNotBlank(wh) && wh.indexOf("-") > -1)) { // 传入了完整的需要压缩的宽高，eg：100-100

                    // 传入了宽高则使用出入的宽高
                    if (wh != null) {
                        // 需要压缩的宽度
                        width = Integer.parseInt(wh.split("-")[0]);
                        // 需要压缩的高度
                        height = Integer.parseInt(wh.split("-")[1]);
                    }

                    // 图片 宽高比例
                    Float ratioOrig = (float) widthOrig / heightOrig;
                    Float ratio = (float) width / height;

                    // 根据尺寸进行压缩，若原图片比例与压缩比例不一致，不损坏原图的情况下，则将相应的缩小尺寸
                    if (ratioOrig == ratio) {
                        // 获取缩略图
                        thumbnail = Thumbnails.of(image).forceSize(width, height).asBufferedImage();
                    } else {
                        if (ratioOrig > ratio) {
                            thumbnail = Thumbnails.of(image).width(width).asBufferedImage();
                        } else {
                            thumbnail = Thumbnails.of(image).height(height).asBufferedImage();
                        }
                        // 以中心按压缩比例进行裁剪，这样则一定会得到要求尺寸的图片，但是会损坏原有的图片
                        // thumbnail =
                        // Thumbnails.of(image).sourceRegion(Positions.CENTER,
                        // width, height).size(width,height).asBufferedImage();
                    }

                } else { // 只传入了高度-方便页面设置高度

                    height = Integer.parseInt(wh);
                    // 只传入高度时，宽度根据高度压缩比例得到
                    width = widthOrig * height / heightOrig;
                    thumbnail = Thumbnails.of(image).forceSize(width, height).asBufferedImage();

                }

                // 输出流
                OutputStream os = response.getOutputStream();
                // 将缩略图写入输入流，JPEG格式
                ImageIO.write(thumbnail, "png", os);
                os.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @description 显示图片的缩略图 使用thumbnailator插件,图片规格不符合将会以中心进行裁剪
     * @author YangHao
     * @date 2018年9月3日-下午10:47:27
     * @param path：图片路径
     * @param wh：1.不传入，使用默认的100px*100px;2.只传入高度，格式：200，高度根据比例得出;3.宽和高都传入格式：100-100
     * @param response
     */
    @ApiOperation(value = "显示图片的缩略图，根据传入宽高裁剪", notes = "")
    @ApiImplicitParams({ @ApiImplicitParam(name = "path", value = "服务器图片路径", required = true, dataType = "String"),
            @ApiImplicitParam(name = "wh", value = "想要获取图片的宽高 格式：100-100", required = false, dataType = "String") })
    @GetMapping(value = "/cutImg")
    public void cutImg(String path, String wh, HttpServletResponse response) {
        if(StringUtils.isNotBlank(path)) {
            // 缩略图
            BufferedImage thumbnail = null;
            // 需要压缩的尺寸，默认20*20
            Integer width = 100;
            Integer height = 100;
            // 组织完整的文件路径
            try {

                // 获取原尺寸的图片
                BufferedImage image = ImageIO.read(new FileInputStream(path));
                // 读取原始图片的宽高
                Integer widthOrig = image.getWidth();
                Integer heightOrig = image.getHeight();

                // 判断是否传入了需要压缩的尺寸
                if (wh == null || // 没有传入压缩尺寸
                        (StringUtils.isNotBlank(wh) && wh.indexOf("-") > -1)) { // 传入了完整的需要压缩的宽高，eg：100-100

                    // 传入了宽高则使用出入的宽高
                    if (wh != null) {
                        // 需要压缩的宽度
                        width = Integer.parseInt(wh.split("-")[0]);
                        // 需要压缩的高度
                        height = Integer.parseInt(wh.split("-")[1]);
                    }

                    // 图片 宽高比例
                    Float ratioOrig = (float) widthOrig / heightOrig;
                    Float ratio = (float) width / height;

                    // 根据尺寸进行压缩，若原图片比例与压缩比例不一致，不损坏原图的情况下，则将相应的缩小尺寸
                    if (Math.abs(ratioOrig - ratio) <= 0) {
                        // 获取缩略图
                        thumbnail = Thumbnails.of(image).forceSize(width, height).asBufferedImage();
                    } else {
                        if (ratioOrig > ratio) {
                            thumbnail = Thumbnails.of(image).width(width).asBufferedImage();
                        } else {
                            thumbnail = Thumbnails.of(image).height(height).asBufferedImage();
                        }
                        // 以中心按压缩比例进行裁剪，这样则一定会得到要求尺寸的图片，但是会损坏原有的图片
                        thumbnail = Thumbnails.of(image).sourceRegion(Positions.CENTER, width, height).size(width, height)
                                .asBufferedImage();
                    }

                } else { // 只传入了高度-方便页面设置高度

                    height = Integer.parseInt(wh);
                    // 只传入高度时，宽度根据高度压缩比例得到
                    width = widthOrig * height / heightOrig;
                    thumbnail = Thumbnails.of(image).forceSize(width, height).asBufferedImage();

                }

                // 输出流
                OutputStream os = response.getOutputStream();
                // 将缩略图写入输入流，JPEG格式
                ImageIO.write(thumbnail, "png", os);
                os.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
