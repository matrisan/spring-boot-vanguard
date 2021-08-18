FROM debian:buster
MAINTAINER shishaodong
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime  && echo 'Asia/Shanghai' > /etc/timezone
RUN apt update && apt install -y libhyperscan-dev lua5.1 liblua5.1-dev luarocks python python-pip vim unzip
RUN apt -y install --no-install-recommends wget gnupg ca-certificates
RUN wget -O - https://openresty.org/package/pubkey.gpg | apt-key add - && statusname=`grep -Po 'VERSION="[0-9]+ \(\K[^)]+' /etc/os-release` && echo "deb http://openresty.org/package/debian $statusname openresty" | tee /etc/apt/sources.list.d/openresty.list
RUN apt update && apt -y install openresty
RUN cd
ADD argparse-0.7.1-1.src.rock .
ADD luahs-master.zip .
RUN luarocks install argparse
RUN unzip luahs-master.zip && cd luahs-master &&  luarocks make
RUN mkdir -p /apprun/install/
ADD moshield.zip /apprun/install/
RUN useradd apprun && cd /apprun/install/ && unzip moshield.zip && cd moshield && make init && make install && make run
WORKDIR /apprun




