package org.apache.myfaces.blank;

public class S3Runner {

    public static void main(String[] args) {

        HelloWorldAWSS3 helloWorldAWSS3 = new HelloWorldAWSS3();

        //helloWorldAWSS3.createBucket(helloWorldAWSS3.bucketName);

        //helloWorldAWSS3.printBucketsNames();

        /*helloWorldAWSS3.uploadObject(helloWorldAWSS3.bucketName,
                helloWorldAWSS3.typeTestFile,
                helloWorldAWSS3.pathToTestFile);*/

        //helloWorldAWSS3.printObjectsNames(helloWorldAWSS3.bucketName);

        /*helloWorldAWSS3.downloadingAnObject(
                helloWorldAWSS3.bucketName,
                helloWorldAWSS3.typeTestFile,
                helloWorldAWSS3.pathToUpload
        );*/

        /*helloWorldAWSS3.copyingRenamingAndMovingAnObject(
                helloWorldAWSS3.bucketName,
                helloWorldAWSS3.typeTestFile,
                helloWorldAWSS3.bucketName2,
                helloWorldAWSS3.typeTestFile
        );*/

        /*String s [] = {""+ helloWorldAWSS3.typeTestFile};
        helloWorldAWSS3.deletingMultipleObjects(s, helloWorldAWSS3.bucketName2);*/

        //helloWorldAWSS3.deleteBucket(helloWorldAWSS3.bucketName2);

        //helloWorldAWSS3.deletingAnObject(helloWorldAWSS3.bucketName, helloWorldAWSS3.typeTestFile);
        //helloWorldAWSS3.deleteBucket(helloWorldAWSS3.bucketName);
    }
}
