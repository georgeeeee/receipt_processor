# how to run receipt_processor

## Step 1: 
mvn clean package (make sure to install maven beforehand)

## Step 2:
docker build -t receipt-processor .

## Step 3:
docker run -p 8080:8080 receipt-processor
