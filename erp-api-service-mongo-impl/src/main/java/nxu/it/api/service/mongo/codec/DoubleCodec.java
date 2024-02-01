package nxu.it.api.service.mongo.codec;

import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.RepresentationConfigurable;
import org.bson.types.Decimal128;

import java.math.BigDecimal;

public class DoubleCodec implements Codec<Double>, RepresentationConfigurable<Double> {

    private BsonType representation;

    @Override
    public void encode(BsonWriter writer, Double value, EncoderContext encoderContext) {
        writer.writeDecimal128(new Decimal128(BigDecimal.valueOf(value)));
    }

    @Override
    public Double decode(BsonReader reader, DecoderContext decoderContext) {
        Decimal128 decimal128 = reader.readDecimal128();
        return decimal128.doubleValue();
    }

    @Override
    public Class<Double> getEncoderClass() {
        return Double.class;
    }

    @Override
    public Codec<Double> withRepresentation(BsonType bsonType) {
        this.representation = bsonType;
        return this;
    }

    @Override
    public BsonType getRepresentation() {
        return representation;
    }
}
