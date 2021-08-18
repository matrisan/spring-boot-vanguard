package com.matrixboot.vanguard.agent;

import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 * <p>
 * create in 2021/8/18 5:16 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class TestMain {

    static List<String> commands = new ArrayList<>();

    static {
        commands.add("");

    }

    static String[] array = new String[]{
            "apt update && apt install -y libhyperscan-dev lua5.1 liblua5.1-dev luarocks python python-pip vim unzip",
            "apt -y install --no-install-recommends wget gnupg ca-certificates",
            "wget -O - https://openresty.org/package/pubkey.gpg | apt-key add - && statusname=`grep -Po 'VERSION=\"[0-9]+ \\(\\K[^)]+' /etc/os-release` && echo \"deb http://openresty.org/package/debian $statusname openresty\" | tee /etc/apt/sources.list.d/openresty.list",
            "apt update && apt -y install openresty",
    };

    public static void main(String[] args) throws InterruptedException {
        DockerImageName dockerImageName = DockerImageName.parse("debian:buster");
        GenericContainer<?> debian = new GenericContainer<>(dockerImageName)
                .withExposedPorts(8088)
//                .withCommand(array)
                ;
        TimeUnit.MINUTES.sleep(1);
        debian.close();

    }


}
