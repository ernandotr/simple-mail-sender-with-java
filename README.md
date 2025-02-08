# Simple App to send email using Java and Gmail

This is a simple app that sends email using Java language and Maven.

### Dependencies
The only dependency used on this project is Jakarta Mail.

```
<dependency>
  <groupId>com.sun.mail</groupId>
  <artifactId>jakarta.mail</artifactId>
  <version>2.0.1</version>
</dependency>
```
### SMTP Server
As a SMTP server I'm using Gmail. To make it possible, was necessary create un App Password in credentials config.
It isn't possible use the same password to log in your Google account.
To create un App Password, go to the following address and follow the instructions:
https://support.google.com/accounts/answer/185833


