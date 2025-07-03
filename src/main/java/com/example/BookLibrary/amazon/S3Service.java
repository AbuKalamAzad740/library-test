package com.example.BookLibrary.amazon;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Service
public class S3Service {

    private final AmazonS3 s3Client;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    public S3Service(@Value("${aws.s3.region}") String region, @Value("${aws.access-key}") String accesKey, @Value("${aws.secret-key}") String secreteKey){
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accesKey, secreteKey);
        this.s3Client = AmazonS3ClientBuilder.standard()
        .withRegion(region)
        .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
        .build();
    }


    public String uploadFile(MultipartFile file) throws IOException{
        System.out.println("bucketName"+bucketName);
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        s3Client.putObject(bucketName, fileName, file.getInputStream(), null);
        return s3Client.getUrl(bucketName, fileName).toString();

    }

    
}
