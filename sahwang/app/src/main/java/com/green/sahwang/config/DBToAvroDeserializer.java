package com.green.sahwang.config;

import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;

import java.io.ByteArrayInputStream;

public class DBToAvroDeserializer {

    public static <T extends SpecificRecordBase> T deserialize(byte[] data, Class<T> clazz) throws Exception {
        DatumReader<T> datumReader = new SpecificDatumReader<>(clazz.newInstance().getSchema());
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        Decoder decoder = DecoderFactory.get().binaryDecoder(inputStream, null);
        return datumReader.read(clazz.newInstance(), decoder);
    }
}
