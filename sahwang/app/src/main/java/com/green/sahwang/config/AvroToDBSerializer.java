package com.green.sahwang.config;

import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecordBase;

import java.io.ByteArrayOutputStream;

public class AvroToDBSerializer {

    public static <T extends SpecificRecordBase> byte[] serialize(T record) throws Exception {
        DatumWriter<T> datumWriter = new SpecificDatumWriter<>(record.getSchema());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Encoder encoder = EncoderFactory.get().binaryEncoder(outputStream, null);
        datumWriter.write(record, encoder);
        encoder.flush();
        outputStream.close();
        return outputStream.toByteArray();
    }
}
