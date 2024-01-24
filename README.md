# Comandos


- https://github.com/seleniumhq-community/docker-seleniarm
- http://localhost:7900/?autoconnect=1&resize=scale&password=secret


```shell
docker run -d --name=chromium --rm -it -p 4444:4444 \
-p 5900:5900 \
-p 7900:7900 \
--shm-size 2g seleniarm/standalone-chromium:latest
```
