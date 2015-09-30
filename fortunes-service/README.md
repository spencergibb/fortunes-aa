```
CREATE KEYSPACE fortunes
   WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
   
CREATE TABLE fortunes.fortune (
    id varchar PRIMARY KEY,
    fortune varchar
);
```