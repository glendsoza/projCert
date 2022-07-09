FROM php:zts-alpine3.16

WORKDIR /www

COPY website/ ./

CMD ["-S", "0.0.0.0:8000"]

ENTRYPOINT [ "php"]

