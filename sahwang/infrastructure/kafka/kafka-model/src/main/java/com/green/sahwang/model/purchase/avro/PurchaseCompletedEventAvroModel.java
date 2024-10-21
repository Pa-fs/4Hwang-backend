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
public class PurchaseCompletedEventAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4021416555459997629L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PurchaseCompletedEventAvroModel\",\"namespace\":\"com.green.sahwang.model.purchase.avro\",\"fields\":[{\"name\":\"purchaseId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"memberId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"purchaseDate\",\"type\":\"long\"},{\"name\":\"purchaseStatus\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"totalAmount\",\"type\":\"int\"},{\"name\":\"shippingAddress\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<PurchaseCompletedEventAvroModel> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PurchaseCompletedEventAvroModel> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<PurchaseCompletedEventAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<PurchaseCompletedEventAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<PurchaseCompletedEventAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this PurchaseCompletedEventAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a PurchaseCompletedEventAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a PurchaseCompletedEventAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static PurchaseCompletedEventAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String purchaseId;
  private java.lang.String memberId;
  private long purchaseDate;
  private java.lang.String purchaseStatus;
  private int totalAmount;
  private java.lang.String shippingAddress;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PurchaseCompletedEventAvroModel() {}

  /**
   * All-args constructor.
   * @param purchaseId The new value for purchaseId
   * @param memberId The new value for memberId
   * @param purchaseDate The new value for purchaseDate
   * @param purchaseStatus The new value for purchaseStatus
   * @param totalAmount The new value for totalAmount
   * @param shippingAddress The new value for shippingAddress
   */
  public PurchaseCompletedEventAvroModel(java.lang.String purchaseId, java.lang.String memberId, java.lang.Long purchaseDate, java.lang.String purchaseStatus, java.lang.Integer totalAmount, java.lang.String shippingAddress) {
    this.purchaseId = purchaseId;
    this.memberId = memberId;
    this.purchaseDate = purchaseDate;
    this.purchaseStatus = purchaseStatus;
    this.totalAmount = totalAmount;
    this.shippingAddress = shippingAddress;
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
    case 2: return purchaseDate;
    case 3: return purchaseStatus;
    case 4: return totalAmount;
    case 5: return shippingAddress;
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
    case 2: purchaseDate = (java.lang.Long)value$; break;
    case 3: purchaseStatus = value$ != null ? value$.toString() : null; break;
    case 4: totalAmount = (java.lang.Integer)value$; break;
    case 5: shippingAddress = value$ != null ? value$.toString() : null; break;
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
   * Gets the value of the 'purchaseDate' field.
   * @return The value of the 'purchaseDate' field.
   */
  public long getPurchaseDate() {
    return purchaseDate;
  }


  /**
   * Sets the value of the 'purchaseDate' field.
   * @param value the value to set.
   */
  public void setPurchaseDate(long value) {
    this.purchaseDate = value;
  }

  /**
   * Gets the value of the 'purchaseStatus' field.
   * @return The value of the 'purchaseStatus' field.
   */
  public java.lang.String getPurchaseStatus() {
    return purchaseStatus;
  }


  /**
   * Sets the value of the 'purchaseStatus' field.
   * @param value the value to set.
   */
  public void setPurchaseStatus(java.lang.String value) {
    this.purchaseStatus = value;
  }

  /**
   * Gets the value of the 'totalAmount' field.
   * @return The value of the 'totalAmount' field.
   */
  public int getTotalAmount() {
    return totalAmount;
  }


  /**
   * Sets the value of the 'totalAmount' field.
   * @param value the value to set.
   */
  public void setTotalAmount(int value) {
    this.totalAmount = value;
  }

  /**
   * Gets the value of the 'shippingAddress' field.
   * @return The value of the 'shippingAddress' field.
   */
  public java.lang.String getShippingAddress() {
    return shippingAddress;
  }


  /**
   * Sets the value of the 'shippingAddress' field.
   * @param value the value to set.
   */
  public void setShippingAddress(java.lang.String value) {
    this.shippingAddress = value;
  }

  /**
   * Creates a new PurchaseCompletedEventAvroModel RecordBuilder.
   * @return A new PurchaseCompletedEventAvroModel RecordBuilder
   */
  public static com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder newBuilder() {
    return new com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder();
  }

  /**
   * Creates a new PurchaseCompletedEventAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new PurchaseCompletedEventAvroModel RecordBuilder
   */
  public static com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder newBuilder(com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder other) {
    if (other == null) {
      return new com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder();
    } else {
      return new com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new PurchaseCompletedEventAvroModel RecordBuilder by copying an existing PurchaseCompletedEventAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new PurchaseCompletedEventAvroModel RecordBuilder
   */
  public static com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder newBuilder(com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel other) {
    if (other == null) {
      return new com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder();
    } else {
      return new com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for PurchaseCompletedEventAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PurchaseCompletedEventAvroModel>
    implements org.apache.avro.data.RecordBuilder<PurchaseCompletedEventAvroModel> {

    private java.lang.String purchaseId;
    private java.lang.String memberId;
    private long purchaseDate;
    private java.lang.String purchaseStatus;
    private int totalAmount;
    private java.lang.String shippingAddress;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.purchaseId)) {
        this.purchaseId = data().deepCopy(fields()[0].schema(), other.purchaseId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.memberId)) {
        this.memberId = data().deepCopy(fields()[1].schema(), other.memberId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.purchaseDate)) {
        this.purchaseDate = data().deepCopy(fields()[2].schema(), other.purchaseDate);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.purchaseStatus)) {
        this.purchaseStatus = data().deepCopy(fields()[3].schema(), other.purchaseStatus);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.totalAmount)) {
        this.totalAmount = data().deepCopy(fields()[4].schema(), other.totalAmount);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.shippingAddress)) {
        this.shippingAddress = data().deepCopy(fields()[5].schema(), other.shippingAddress);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
    }

    /**
     * Creates a Builder by copying an existing PurchaseCompletedEventAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.purchaseId)) {
        this.purchaseId = data().deepCopy(fields()[0].schema(), other.purchaseId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.memberId)) {
        this.memberId = data().deepCopy(fields()[1].schema(), other.memberId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.purchaseDate)) {
        this.purchaseDate = data().deepCopy(fields()[2].schema(), other.purchaseDate);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.purchaseStatus)) {
        this.purchaseStatus = data().deepCopy(fields()[3].schema(), other.purchaseStatus);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.totalAmount)) {
        this.totalAmount = data().deepCopy(fields()[4].schema(), other.totalAmount);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.shippingAddress)) {
        this.shippingAddress = data().deepCopy(fields()[5].schema(), other.shippingAddress);
        fieldSetFlags()[5] = true;
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
    public com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder setPurchaseId(java.lang.String value) {
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
    public com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder clearPurchaseId() {
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
    public com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder setMemberId(java.lang.String value) {
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
    public com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder clearMemberId() {
      memberId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'purchaseDate' field.
      * @return The value.
      */
    public long getPurchaseDate() {
      return purchaseDate;
    }


    /**
      * Sets the value of the 'purchaseDate' field.
      * @param value The value of 'purchaseDate'.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder setPurchaseDate(long value) {
      validate(fields()[2], value);
      this.purchaseDate = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'purchaseDate' field has been set.
      * @return True if the 'purchaseDate' field has been set, false otherwise.
      */
    public boolean hasPurchaseDate() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'purchaseDate' field.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder clearPurchaseDate() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'purchaseStatus' field.
      * @return The value.
      */
    public java.lang.String getPurchaseStatus() {
      return purchaseStatus;
    }


    /**
      * Sets the value of the 'purchaseStatus' field.
      * @param value The value of 'purchaseStatus'.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder setPurchaseStatus(java.lang.String value) {
      validate(fields()[3], value);
      this.purchaseStatus = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'purchaseStatus' field has been set.
      * @return True if the 'purchaseStatus' field has been set, false otherwise.
      */
    public boolean hasPurchaseStatus() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'purchaseStatus' field.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder clearPurchaseStatus() {
      purchaseStatus = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'totalAmount' field.
      * @return The value.
      */
    public int getTotalAmount() {
      return totalAmount;
    }


    /**
      * Sets the value of the 'totalAmount' field.
      * @param value The value of 'totalAmount'.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder setTotalAmount(int value) {
      validate(fields()[4], value);
      this.totalAmount = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'totalAmount' field has been set.
      * @return True if the 'totalAmount' field has been set, false otherwise.
      */
    public boolean hasTotalAmount() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'totalAmount' field.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder clearTotalAmount() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'shippingAddress' field.
      * @return The value.
      */
    public java.lang.String getShippingAddress() {
      return shippingAddress;
    }


    /**
      * Sets the value of the 'shippingAddress' field.
      * @param value The value of 'shippingAddress'.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder setShippingAddress(java.lang.String value) {
      validate(fields()[5], value);
      this.shippingAddress = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'shippingAddress' field has been set.
      * @return True if the 'shippingAddress' field has been set, false otherwise.
      */
    public boolean hasShippingAddress() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'shippingAddress' field.
      * @return This builder.
      */
    public com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel.Builder clearShippingAddress() {
      shippingAddress = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PurchaseCompletedEventAvroModel build() {
      try {
        PurchaseCompletedEventAvroModel record = new PurchaseCompletedEventAvroModel();
        record.purchaseId = fieldSetFlags()[0] ? this.purchaseId : (java.lang.String) defaultValue(fields()[0]);
        record.memberId = fieldSetFlags()[1] ? this.memberId : (java.lang.String) defaultValue(fields()[1]);
        record.purchaseDate = fieldSetFlags()[2] ? this.purchaseDate : (java.lang.Long) defaultValue(fields()[2]);
        record.purchaseStatus = fieldSetFlags()[3] ? this.purchaseStatus : (java.lang.String) defaultValue(fields()[3]);
        record.totalAmount = fieldSetFlags()[4] ? this.totalAmount : (java.lang.Integer) defaultValue(fields()[4]);
        record.shippingAddress = fieldSetFlags()[5] ? this.shippingAddress : (java.lang.String) defaultValue(fields()[5]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PurchaseCompletedEventAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<PurchaseCompletedEventAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PurchaseCompletedEventAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<PurchaseCompletedEventAvroModel>)MODEL$.createDatumReader(SCHEMA$);

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

    out.writeLong(this.purchaseDate);

    out.writeString(this.purchaseStatus);

    out.writeInt(this.totalAmount);

    out.writeString(this.shippingAddress);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.purchaseId = in.readString();

      this.memberId = in.readString();

      this.purchaseDate = in.readLong();

      this.purchaseStatus = in.readString();

      this.totalAmount = in.readInt();

      this.shippingAddress = in.readString();

    } else {
      for (int i = 0; i < 6; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.purchaseId = in.readString();
          break;

        case 1:
          this.memberId = in.readString();
          break;

        case 2:
          this.purchaseDate = in.readLong();
          break;

        case 3:
          this.purchaseStatus = in.readString();
          break;

        case 4:
          this.totalAmount = in.readInt();
          break;

        case 5:
          this.shippingAddress = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









