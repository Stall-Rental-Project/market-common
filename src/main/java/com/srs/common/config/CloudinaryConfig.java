package com.srs.common.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class CloudinaryConfig {
//    private static final String CLOUD_NAME = "ban-vien";
//    private static final String CLOUDINARY_API_KEY = "117784362653246";
//    private static final String CLOUDINARY_API_SECRET = "XfcUsfz7LK7cdjj7Q5rf6BrxCEo";
//    private static final String CLOUDINARY_UPLOAD_FOLDER = "mhmarket";
//
//    public CloudinaryConfig() {
//        new Cloudinary(ObjectUtils.asMap(
//                "cloud_name", CLOUD_NAME,
//                "api_key", CLOUDINARY_API_KEY,
//                "api_secret", CLOUDINARY_API_SECRET,
//                "secure", true));
//    }
//
//    public static Cloudinary getCloudinaryClient() {
//        return new Cloudinary(ObjectUtils.asMap(
//                "cloud_name", CLOUD_NAME,
//                "api_key", CLOUDINARY_API_KEY,
//                "api_secret", CLOUDINARY_API_SECRET,
//                "secure", true));
//    }

//    public String getFileUpload() throws Exception {
//        Cloudinary cloudinary = getCloudinaryClient();
//        Map result = cloudinary.url().("01a297b8-482a-456d-bb3d-2ece41d2c3dc", ObjectUtils.emptyMap());
//        return result.get("url").toString();
//    }
//    private Cloudinary cloudinary;
//    @Autowired
//    public CloudinaryConfig(@Value("${cloud.key}") String key,
//                            @Value("${cloud.secret}") String secret,
//                            @Value("${cloud.name}") String cloud) {
//        cloudinary.config.cloudName=cloud;
//        cloudinary.config.apiSecret=secret;
//        cloudinary.config.apiKey=key;
//    }
//
//    public Map upload(Object file, Map options){
//        try {
//            return cloudinary.uploader().upload(file, options);
//        } catch    (IOException e)  {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    public String createUrl(String name, int width,
//                            int height, String action){
//        return cloudinary.url()
//                .transformation(new Transformation()
//                        .width(width).height(height)
//                        .border("2px_solid_black").crop(action))
//                .imageTag(name);
//    }
}
