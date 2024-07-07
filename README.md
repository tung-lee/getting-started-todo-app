# A todo-List App using Docker and Localstack

This full-stack Todo application was built with React, Node.js, Express, Mongo and Localstack(S3 emulated).

## Tech Stack

![image](https://github.com/dockersamples/getting-started-todo-app/assets/313480/a8dc1a00-24b8-4d04-9252-e90c9e359dbd)


Frontend: React, Material UI.
Backend: Node.js, Express
Database: Mongo(running locally for storing tasks)
Object Storage: Localstack (for emulating S3 and storing images locally for testing purpose)


## Prerequisites

- Docker Desktop
- JWT Secret
- awscli installed


## Installation

1. **Clone the repository:**

```sh
git clone https://github.com/dockersamples/getting-started-todo-app
cd getting-started-todo-app
```


2. **Bringing up services:**

Switch to container-supported branch before you run the following command:

```
git checkout container-supported
```



```
 docker compose up -d
```

<img width="1151" alt="image" src="https://github.com/dockersamples/getting-started-todo-app/assets/313480/c81c8e3b-847a-4a93-a960-8d01960d7b4c">



## Create S3 bucket manually

```
awslocal s3 mb s3://sample-bucket
make_bucket: sample-bucket
```

## Check the logs

```
2024-07-03 19:27:32 
2024-07-03 19:27:32 LocalStack version: 3.5.1.dev
2024-07-03 19:27:32 LocalStack build date: 2024-06-24
2024-07-03 19:27:32 LocalStack build git hash: 9a3d238ac
2024-07-03 19:27:32 
2024-07-03 19:27:32 Ready.
2024-07-03 19:28:13 2024-07-03T13:58:13.804  INFO --- [et.reactor-0] localstack.request.aws     : AWS s3.CreateBucket => 200
```

## Access the app and try uploading the image

```
 awslocal s3api list-objects --bucket sample-bucket
{
    "Contents": [
        {
            "Key": "1720015203095-Screenshot 2024-07-03 at 9.24.34â¯AM.png",
            "LastModified": "2024-07-03T14:00:03.000Z",
            "ETag": "\"cd4396baa401efb22797472599faff87\"",
            "Size": 735617,
            "StorageClass": "STANDARD",
            "Owner": {
                "DisplayName": "webfile",
                "ID": "75aa57f09aa0c8caeab4f8c24e99d10f8e7faeebf76c078efc7c6caea54ba06a"
            }
        }
    ],
    "RequestCharged": null
```

## Verify if item gets into Mongo

```
Connecting to:          mongodb://127.0.0.1:27017/?directConnection=true&serverSelectionTimeoutMS=2000&appName=mongosh+2.2.10
Using MongoDB:          7.0.12
Using Mongosh:          2.2.10

For mongosh info see: https://docs.mongodb.com/mongodb-shell/

------
   The server generated these startup warnings when booting
   2024-07-03T13:57:31.418+00:00: Using the XFS filesystem is strongly recommended with the WiredTiger storage engine. See http://dochub.mongodb.org/core/prodnotes-filesystem
   2024-07-03T13:57:32.732+00:00: Access control is not enabled for the database. Read and write access to data and configuration is unrestricted
   2024-07-03T13:57:32.733+00:00: /sys/kernel/mm/transparent_hugepage/enabled is 'always'. We suggest setting it to 'never' in this binary version
   2024-07-03T13:57:32.733+00:00: vm.max_map_count is too low
------

test> show dbs
admin      40.00 KiB
config     72.00 KiB
local      80.00 KiB
todo-app  180.00 KiB
test> use todo-app
switched to db todo-app
todo-app> db.todos.countDocuments()
5
todo-app> db.todos.countDocuments()
6
todo-app>
```


