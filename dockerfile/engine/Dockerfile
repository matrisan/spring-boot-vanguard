FROM debian:buster

MAINTAINER shishaodong
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime  && echo 'Asia/Shanghai' >/etc/timezone
RUN apt update && apt install -y libhyperscan-dev lua5.1 liblua5.1-dev luarocks git python python-pip vim && cd && git clone https://github.com/starius/luahs.git && cd luahs && pip install argparse && luarocks make
RUN apt-get -y install --no-install-recommends wget gnupg ca-certificates
RUN wget -O - https://openresty.org/package/pubkey.gpg | sudo apt-key add - && statusname=`grep -Po 'VERSION="[0-9]+ \(\K[^)]+' /etc/os-release` && echo "deb http://openresty.org/package/debian $statusname openresty" | sudo tee /etc/apt/sources.list.d/openresty.list && apt-get update && apt-get -y install openresty
RUN mkdir -p /apprun/install/
ADD moshield.tar.gz /apprun/install/

RUN useradd apprun && cd /apprun/install/moshield && make init && make install && make run

WORKDIR /apprun




