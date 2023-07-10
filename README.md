## Introduction

This is the capstone project submission to Indian Institute of Information Technology (IIIT) Bangalore, India for completion of Post Graduate Diploma in Software Development (Cloud Computing).

This is the backend of an application to book doctor appointments. The application has five microservices and an API Gateway. It can be deployed with or without Docker. 

## High Level Architecture

![HLD](/meta/HLD.png)

Note: Doctor onboarding and user onboarding services are not shown in the diagram.

### API-1: Make New Appointment

Endpoint -

```
POST localhost:8080/appointment
Content-Type application/json
```

Request Body Ex –

```
	{
   	 "doctorId": "504566071",
    	 "userId": "1204560012",
    	 "appointmentDate": "2021-02-10",
    	 "timSlot": "14:20"
	}
```

Response Body Ex -

```
	{
    	 "appointmentId": 3,
   	 "doctorId": "504566071",
    	 "userId": "1204560012",
    	 "appointmentDate": "2021-02-10",
    	 "timSlot": "14:20"
    	 "status": "PaymentPending"
    	 "transactionId": 0
	}
```

### API-2: Complete transaction

Endpoint -

```
POST localhost:8080/appointment/{appointment-id}/transaction
Content-Type application/json
```

Request Body Ex –

```
	{
   	 "paymentMode": "CARD",
	 "appointmentId": 3,
	 "upiId":"",
	 "cardNumber":"Test Card Number"
	}
```

Response Body Ex -

```
	{
    	 "appointmentId": 3,
   	 "doctorId": "504566071",
    	 "userId": "1204560012",
    	 "appointmentDate": "2021-02-10",
    	 "timSlot": "14:20"
    	 "status": "Confirmed"
    	 "transactionId": 2
	}
```


## Payment Service

### API-3: Save Transaction and return transactionId

Endpoint -

```
POST localhost:8083/transaction
Content-Type application/json
```

Request Body Ex –

```
	{
   	 "paymentMode": "CARD",
	 "bookingId": 1,
	 "upiId":"",
	 "cardNumber":"Test Card 2"
	}
```

Response Body Ex -

```
	{
   	 "transactionId": 2,
	}
```

### API-4: Fetch details of a transaction

Endpoint -

```
GET localhost:8083/transaction/2
```

Response Body Ex -

```
	{
   	 "transactionId": 2,
    	 "bookingId": 1,
    	 "paymentMode": "CARD",
    	 "upiId": null,
    	 "cardNumber": "Test Card Number"
	}
```

## Notification Service

Notification service is also made as a simple spring boot application. The main method sets the Kafka properties and subscribes to the topic "message". It starts consuming messages in a forever loop for notification service using Kafka and prints it on the console. Kafka server and zookeeper runs on an AWS EC2 instance. This is a small sample to show that the notification is being pushed succesfully by the Booking Service to Kafka.

Please set the EC2 connection endpoint under property "bootstrap.servers" for the notifications to be fetched.

Ex. from console - 

![notification](/meta/notification.png)

## Eureka Server

Eureka Server is an application that holds the information about all client-service applications. It knows all the client applications running on each port and IP address. Eureka Server is also known as Discovery Server.

The Booking and Payment services registers themselves into the Eureka server.

The Eureka Server is started on port 8761. On the browser if we go to http://localhost:8761/ we can see the Booking and Payment services are up –

![Eureka](/meta/eureka-1.png)


# Logic Flow

### Making a new booking -


<a href=""><img src="/meta/flowchart-1.png" alt="flow-1" width="400" border="10" /></a>


### Completing a transaction to confirm booking -

<a href=""><img src="/meta/flowchart-2.png" alt="flow-2" width="400" border="10" /></a>

# Future Enhancements

1.  Add error and exception handling at all the possible points


