package org.playground;

import org.apache.commons.lang3.StringUtils;
import org.playground.model.Person;
import org.playground.model.PersonBuilder;

import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // 名前・メールアドレスが空白ではないもので、先頭の1件の名前を出力
        Optional<String> nameFoundFirstOpt = Stream.of(
                new PersonBuilder().setName("   ").setEmail("empty@name.user").build(),
                new PersonBuilder().setName("Taro").setEmail("taro@example.co.jp").build(),
                new PersonBuilder().setName("Bingo").setEmail("bin.go@sample.org").build(),
                new PersonBuilder().setName("emptyEmail").setEmail("").build())
                .filter( aPerson -> StringUtils.isNotBlank(aPerson.getName()) )
                .filter( aPerson -> StringUtils.isNotBlank(aPerson.getEmail()) )
                .map(Person::getName)
                .findFirst();

        nameFoundFirstOpt.ifPresent(nameFound -> {
            System.out.println("nameFound >> " + nameFound);
        });
    }

}