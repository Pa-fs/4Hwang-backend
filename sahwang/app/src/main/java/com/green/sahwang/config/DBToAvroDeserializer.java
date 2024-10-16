package com.green.sahwang.config;

import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;

import java.io.ByteArrayInputStream;

import org.apache.avro.Schema;

import org.apache.avro.Schema;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;

import java.io.ByteArrayInputStream;

public class DBToAvroDeserializer {

    public static <T extends SpecificRecordBase> T deserialize(byte[] data, Class<?> clazz) throws Exception {
        // Avro에서 생성된 SpecificRecord의 Schema를 가져오기
        Schema schema = (Schema) clazz.getDeclaredField("SCHEMA$").get(null);
        // DatumReader 초기화
        DatumReader<T> datumReader = new SpecificDatumReader<>(schema);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        // Decoder 생성
        Decoder decoder = DecoderFactory.get().binaryDecoder(inputStream, null);
        // 역직렬화 수행
        return datumReader.read(null, decoder);
    }
}
