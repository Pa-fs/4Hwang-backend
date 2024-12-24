/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.green.sahwang.model.purchase.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class PurchaseCreatedEventAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2220943235914506983L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PurchaseCreatedEventAvroModel\",\"namespace\":\"com.green.sahwang.model.purchase.avro\",\"fields\":[{\"name\":\"purchaseId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"memberId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"usedProducts\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"PurchaseAvroModel\",\"fields\":[{\"name\":\"usedProductId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"quantity\",\"type\":\"int\"}]}}},{\"name\":\"totalPrice\",\"type\":\"long\"},{\"name\":\"timestamp\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<PurchaseCreatedEventAvroModel> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PurchaseCreatedEventAvroModel> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<PurchaseCreatedEventAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<PurchaseCreatedEventAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<PurchaseCreatedEventAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this PurchaseCreatedEventAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a PurchaseCreatedEventAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a PurchaseCreatedEventAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static PurchaseCreatedEventAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String purchaseId;
  private java.lang.String memberId;
  private java.util.List<com.green.sahwang.model.purchase.avro.PurchaseAvroModel> usedProducts;
  private long totalPrice;
  private long timestamp;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PurchaseCreatedEventAvroModel() {}

  /**
   * All-args constructor.
   * @param purchaseId The new value for purchaseId
   * @param memberId The new value for memberId
   * @param usedProducts The new value for usedProducts
   * @param totalPrice The new value for totalPrice
   * @param timestamp The new value for timestamp
   */
  public PurchaseCreatedEventAvroModel(java.lang.String purchaseId, java.lang.String memberId, java.util.List<com.green.sahwang.model.purchase.avro.PurchaseAvroModel> usedProducts, java.lang.Long totalPrice, java.lang.Long timestamp) {
    this.purchaseId = purchaseId;
    this.memberId = memberId;
    this.usedProducts = usedProducts;
    this.totalPrice = totalPrice;
    this.timestamp = timestamp;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return purchaseId;
    case 1: return memberId;
    case 2: return usedProducts;
    case 3: return totalPrice;
    case 4: return timestamp;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: purchaseId = value$ != null ? value$.toString() : null; break;
    case 1: memberId = value$ != null ? value$.toString() : null; break;
    case 2: usedProducts = (java.util.List<com.green.sahwang.model.purchase.avro.PurchaseAvroModel>)value$; break;
    case 3: totalPrice = (java.lang.Long)value$; break;
    case 4: timestamp = (java.lang.Long)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'purchaseId' field.
   * @return The value of the 'purchaseId' field.
   */
  public java.lang.String getPurchaseId() {
    return purchaseId;
  }


  /**
   * Sets the value of the 'purchaseId' field.
   * @param value the value to set.
   */
  public void setPurchaseId(java.lang.String value) {
    this.purchaseId = value;
  }

  /**
   * Gets the value of the 'memberId' field.
   * @return The value of the 'memberId' field.
   */
  public java.lang.String getMemberId() {
    return memberId;
  }


  /**
   * Sets the value of the 'memberId' field.
   * @param value the value to set.
   */
  public void setMemberId(java.lang.String value) {
    this.memberId = value;
  }

  /**
   * Gets the value of the 'usedProducts' field.
   * @return The value of the 'usedProducts' field.
   */
  public java.util.List<com.green.sahwang.model.purchase.avro.PurchaseAvroModel> getUsedProducts() {
    return usedProducts;
  }


  /**
   * Sets the value of the 'usedProducts' field.
   * @param value the value to set.
   */
  public void setUsedProducts(java.util.List<com.green.sahwang.model.purchase.avro.PurchaseAvroModel> value) {
    this.usedProducts = value;
  }

  /**
   * Gets the value of the 'totalPrice' field.
   * @return The value of the 'totalPrice' field.
   */
  public long getTotalPrice() {
    return totalPrice;
  }


  /**
   * Sets the value of the 'totalPrice' field.
   * @param value the value to set.
   */
  public void setTotalPrice(long value) {
    this.totalPrice = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   * @return The value of the 'timestamp' field.
   */
  public long getTimestamp() {
    return timestamp;
  }


  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(long value) {
    this.timestamp = value;
  }

  /**
   * Creates a new PurchaseCreatedEventAvroModel RecordBuilder.
   * @return A new PurchaseCreatedEventAvroModel RecordBuilder
   */
  public static com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder newBuilder() {
    return new com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder();
  }

  /**
   * Creates a new PurchaseCreatedEventAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new PurchaseCreatedEventAvroModel RecordBuilder
   */
  public static com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder newBuilder(com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder other) {
    if (other == null) {
      return new com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder();
    } else {
      return new com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new PurchaseCreatedEventAvroModel RecordBuilder by copying an existing PurchaseCreatedEventAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new PurchaseCreatedEventAvroModel RecordBuilder
   */
  public static com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder newBuilder(com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel other) {
    if (other == null) {
      return new com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder();
    } else {
      return new com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for PurchaseCreatedEventAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PurchaseCreatedEventAvroModel>
    implements org.apache.avro.data.RecordBuilder<PurchaseCreatedEventAvroModel> {

    private java.lang.String purchaseId;
    private java.lang.String memberId;
    private java.util.List<com.green.sahwang.model.purchase.avro.PurchaseAvroModel> usedProducts;
    private long totalPrice;
    private long timestamp;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.purchaseId)) {
        this.purchaseId = data().deepCopy(fields()[0].schema(), other.purchaseId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.memberId)) {
        this.memberId = data().deepCopy(fields()[1].schema(), other.memberId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.usedProducts)) {
        this.usedProducts = data().deepCopy(fields()[2].schema(), other.usedProducts);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.totalPrice)) {
        this.totalPrice = data().deepCopy(fields()[3].schema(), other.totalPrice);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[4].schema(), other.timestamp);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing PurchaseCreatedEventAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.purchaseId)) {
        this.purchaseId = data().deepCopy(fields()[0].schema(), other.purchaseId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.memberId)) {
        this.memberId = data().deepCopy(fields()[1].schema(), other.memberId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.usedProducts)) {
        this.usedProducts = data().deepCopy(fields()[2].schema(), other.usedProducts);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.totalPrice)) {
        this.totalPrice = data().deepCopy(fields()[3].schema(), other.totalPrice);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[4].schema(), other.timestamp);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'purchaseId' field.
      * @return The value.
      */
    public java.lang.String getPurchaseId() {
      return purchaseId;
    }


    /**
      * Sets the value of the 'purchaseId' field.
      * @param value The value of 'purchaseId'.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder setPurchaseId(java.lang.String value) {
      validate(fields()[0], value);
      this.purchaseId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'purchaseId' field has been set.
      * @return True if the 'purchaseId' field has been set, false otherwise.
      */
    public boolean hasPurchaseId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'purchaseId' field.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder clearPurchaseId() {
      purchaseId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'memberId' field.
      * @return The value.
      */
    public java.lang.String getMemberId() {
      return memberId;
    }


    /**
      * Sets the value of the 'memberId' field.
      * @param value The value of 'memberId'.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder setMemberId(java.lang.String value) {
      validate(fields()[1], value);
      this.memberId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'memberId' field has been set.
      * @return True if the 'memberId' field has been set, false otherwise.
      */
    public boolean hasMemberId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'memberId' field.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder clearMemberId() {
      memberId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'usedProducts' field.
      * @return The value.
      */
    public java.util.List<com.green.sahwang.model.purchase.avro.PurchaseAvroModel> getUsedProducts() {
      return usedProducts;
    }


    /**
      * Sets the value of the 'usedProducts' field.
      * @param value The value of 'usedProducts'.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder setUsedProducts(java.util.List<com.green.sahwang.model.purchase.avro.PurchaseAvroModel> value) {
      validate(fields()[2], value);
      this.usedProducts = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'usedProducts' field has been set.
      * @return True if the 'usedProducts' field has been set, false otherwise.
      */
    public boolean hasUsedProducts() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'usedProducts' field.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder clearUsedProducts() {
      usedProducts = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'totalPrice' field.
      * @return The value.
      */
    public long getTotalPrice() {
      return totalPrice;
    }


    /**
      * Sets the value of the 'totalPrice' field.
      * @param value The value of 'totalPrice'.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder setTotalPrice(long value) {
      validate(fields()[3], value);
      this.totalPrice = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'totalPrice' field has been set.
      * @return True if the 'totalPrice' field has been set, false otherwise.
      */
    public boolean hasTotalPrice() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'totalPrice' field.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder clearTotalPrice() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'timestamp' field.
      * @return The value.
      */
    public long getTimestamp() {
      return timestamp;
    }


    /**
      * Sets the value of the 'timestamp' field.
      * @param value The value of 'timestamp'.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder setTimestamp(long value) {
      validate(fields()[4], value);
      this.timestamp = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel.Builder clearTimestamp() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PurchaseCreatedEventAvroModel build() {
      try {
        PurchaseCreatedEventAvroModel record = new PurchaseCreatedEventAvroModel();
        record.purchaseId = fieldSetFlags()[0] ? this.purchaseId : (java.lang.String) defaultValue(fields()[0]);
        record.memberId = fieldSetFlags()[1] ? this.memberId : (java.lang.String) defaultValue(fields()[1]);
        record.usedProducts = fieldSetFlags()[2] ? this.usedProducts : (java.util.List<com.green.sahwang.model.purchase.avro.PurchaseAvroModel>) defaultValue(fields()[2]);
        record.totalPrice = fieldSetFlags()[3] ? this.totalPrice : (java.lang.Long) defaultValue(fields()[3]);
        record.timestamp = fieldSetFlags()[4] ? this.timestamp : (java.lang.Long) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PurchaseCreatedEventAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<PurchaseCreatedEventAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PurchaseCreatedEventAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<PurchaseCreatedEventAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.purchaseId);

    out.writeString(this.memberId);

    long size0 = this.usedProducts.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (com.green.sahwang.model.purchase.avro.PurchaseAvroModel e0: this.usedProducts) {
      actualSize0++;
      out.startItem();
      e0.customEncode(out);
    }
    out.writeArrayEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

    out.writeLong(this.totalPrice);

    out.writeLong(this.timestamp);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.purchaseId = in.readString();

      this.memberId = in.readString();

      long size0 = in.readArrayStart();
      java.util.List<com.green.sahwang.model.purchase.avro.PurchaseAvroModel> a0 = this.usedProducts;
      if (a0 == null) {
        a0 = new SpecificData.Array<com.green.sahwang.model.purchase.avro.PurchaseAvroModel>((int)size0, SCHEMA$.getField("usedProducts").schema());
        this.usedProducts = a0;
      } else a0.clear();
      SpecificData.Array<com.green.sahwang.model.purchase.avro.PurchaseAvroModel> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<com.green.sahwang.model.purchase.avro.PurchaseAvroModel>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          com.green.sahwang.model.purchase.avro.PurchaseAvroModel e0 = (ga0 != null ? ga0.peek() : null);
          if (e0 == null) {
            e0 = new com.green.sahwang.model.purchase.avro.PurchaseAvroModel();
          }
          e0.customDecode(in);
          a0.add(e0);
        }
      }

      this.totalPrice = in.readLong();

      this.timestamp = in.readLong();

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.purchaseId = in.readString();
          break;

        case 1:
          this.memberId = in.readString();
          break;

        case 2:
          long size0 = in.readArrayStart();
          java.util.List<com.green.sahwang.model.purchase.avro.PurchaseAvroModel> a0 = this.usedProducts;
          if (a0 == null) {
            a0 = new SpecificData.Array<com.green.sahwang.model.purchase.avro.PurchaseAvroModel>((int)size0, SCHEMA$.getField("usedProducts").schema());
            this.usedProducts = a0;
          } else a0.clear();
          SpecificData.Array<com.green.sahwang.model.purchase.avro.PurchaseAvroModel> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<com.green.sahwang.model.purchase.avro.PurchaseAvroModel>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              com.green.sahwang.model.purchase.avro.PurchaseAvroModel e0 = (ga0 != null ? ga0.peek() : null);
              if (e0 == null) {
                e0 = new com.green.sahwang.model.purchase.avro.PurchaseAvroModel();
              }
              e0.customDecode(in);
              a0.add(e0);
            }
          }
          break;

        case 3:
          this.totalPrice = in.readLong();
          break;

        case 4:
          this.timestamp = in.readLong();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










