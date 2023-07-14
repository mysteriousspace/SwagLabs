FROM ubuntu:latest
LABEL authors="asinelnik"

ENTRYPOINT ["top", "-b"]