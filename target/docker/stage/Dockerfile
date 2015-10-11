FROM frolvlad/alpine-oraclejdk8
RUN apk update && apk add bash
WORKDIR /opt/docker
ADD opt /opt
RUN ["chown", "-R", "daemon:daemon", "."]
USER daemon
ENTRYPOINT ["bin/egg-scala"]
CMD []
