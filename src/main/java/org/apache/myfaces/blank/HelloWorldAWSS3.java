package org.apache.myfaces.blank;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

public class HelloWorldAWSS3 {

    AWSCredentials credentials = new BasicAWSCredentials(
            "",
            ""
    );
    /**
     *<AWS accesskey>
     *<AWS secretkey>
     * */

    AmazonS3 s3client = AmazonS3ClientBuilder
            .standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .withRegion(Regions.US_EAST_2)
            .build();


    String bucketName2 = "rows-test02-bucket";
    String bucketName = "rows-test-bucket";
    String typeTestFile = "Document/test_text_file.txt";
    String typeTestFile2 = "Document/test_text_file02.txt";
    String typeTestFile3 = "Document/test_text_file03.txt";
    String pathToTestFile = "D:\\proj\\test\\src\\main\\resources\\test_text_file.txt";
    String pathToTestFile2 = "D:\\proj\\test\\src\\main\\resources\\test_text_file02.txt";
    String pathToTestFile3 = "D:\\proj\\test\\src\\main\\resources\\test_text_file03.txt";

    String pathToUpload = "D:\\proj\\test\\src\\main\\resources\\from_amazon_test_text_file.txt";

    public void createBucket (String bucketName) {

        if (s3client.doesBucketExist(bucketName)) {
            System.out.println("Bucket name is not available." +
                    " Try again with a different Bucket name.");
        }else {
            s3client.createBucket(bucketName);
        }
    }

    public void printBucketsNames () {

        List<Bucket> bucketList = s3client.listBuckets();
        bucketList
                .forEach(bucket -> System.out.println(bucket.getName()));
    }

    public void deleteBucket (String bucketName) {

        try{s3client.deleteBucket(bucketName);
        }catch (AmazonServiceException e){
            System.out.println(e.getErrorMessage());
        }
    }

    public void uploadObject (String bucketName, String typeTestFile, String pathToTestFile){
        s3client.putObject(
                bucketName,
                typeTestFile,
                new File(pathToTestFile)
        );
    }

    public void printObjectsNames (String bucketName){
        ObjectListing objectListing = s3client.listObjects(bucketName);
        List<S3ObjectSummary> objectSummaries = objectListing.getObjectSummaries();

        for(S3ObjectSummary objectSummary : objectSummaries){
            System.out.println(objectSummary.getKey());
        }
    }

    public void downloadingAnObject (String bucketName, String typeTestFile, String pathToUpload){
        try {
            S3Object s3Object = s3client.getObject(bucketName, typeTestFile);
            S3ObjectInputStream inputStream = s3Object.getObjectContent();
            FileUtils.copyInputStreamToFile(inputStream, new File(pathToUpload));
        }catch (Exception ex){
            System.out.println();
        }
    }

    public void copyingRenamingAndMovingAnObject (String sourceBucketName,
                                                  String objectKeyInSourceBucket,
                                                  String destinationBucketName,
                                                  String objectKeyInDestinationBucket){

        s3client.copyObject(sourceBucketName,
                objectKeyInSourceBucket,
                destinationBucketName,
                objectKeyInDestinationBucket);
    }

    public void deletingAnObject (String bucketName, String typeTestFile){

        s3client.deleteObject(bucketName, typeTestFile);
    }

    public void deletingMultipleObjects (String objectKeys [], String bucketName){

        DeleteObjectsRequest deleteObjectsRequest = new DeleteObjectsRequest(bucketName).withKeys(objectKeys);
        s3client.deleteObjects(deleteObjectsRequest);
    }
}
