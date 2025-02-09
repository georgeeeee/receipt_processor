# how to run receipt_processor

## Step 0:
cd path/to/receipt_processor

## Step 1: 
run "mvn clean package" (make sure to install maven beforehand)

## Step 2:
run "docker build -t receipt-processor ."

## Step 3:
run "docker run -p 8080:8080 receipt-processor"
