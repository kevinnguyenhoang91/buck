/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.buck.distributed.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2017-01-30")
public class StreamLogs implements org.apache.thrift.TBase<StreamLogs, StreamLogs._Fields>, java.io.Serializable, Cloneable, Comparable<StreamLogs> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("StreamLogs");

  private static final org.apache.thrift.protocol.TField SLAVE_STREAM_FIELD_DESC = new org.apache.thrift.protocol.TField("slaveStream", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField LOG_LINE_BATCHES_FIELD_DESC = new org.apache.thrift.protocol.TField("logLineBatches", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField ERROR_MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("errorMessage", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new StreamLogsStandardSchemeFactory());
    schemes.put(TupleScheme.class, new StreamLogsTupleSchemeFactory());
  }

  public SlaveStream slaveStream; // optional
  public List<LogLineBatch> logLineBatches; // optional
  public String errorMessage; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SLAVE_STREAM((short)1, "slaveStream"),
    LOG_LINE_BATCHES((short)2, "logLineBatches"),
    ERROR_MESSAGE((short)3, "errorMessage");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SLAVE_STREAM
          return SLAVE_STREAM;
        case 2: // LOG_LINE_BATCHES
          return LOG_LINE_BATCHES;
        case 3: // ERROR_MESSAGE
          return ERROR_MESSAGE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.SLAVE_STREAM,_Fields.LOG_LINE_BATCHES,_Fields.ERROR_MESSAGE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SLAVE_STREAM, new org.apache.thrift.meta_data.FieldMetaData("slaveStream", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, SlaveStream.class)));
    tmpMap.put(_Fields.LOG_LINE_BATCHES, new org.apache.thrift.meta_data.FieldMetaData("logLineBatches", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, LogLineBatch.class))));
    tmpMap.put(_Fields.ERROR_MESSAGE, new org.apache.thrift.meta_data.FieldMetaData("errorMessage", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(StreamLogs.class, metaDataMap);
  }

  public StreamLogs() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public StreamLogs(StreamLogs other) {
    if (other.isSetSlaveStream()) {
      this.slaveStream = new SlaveStream(other.slaveStream);
    }
    if (other.isSetLogLineBatches()) {
      List<LogLineBatch> __this__logLineBatches = new ArrayList<LogLineBatch>(other.logLineBatches.size());
      for (LogLineBatch other_element : other.logLineBatches) {
        __this__logLineBatches.add(new LogLineBatch(other_element));
      }
      this.logLineBatches = __this__logLineBatches;
    }
    if (other.isSetErrorMessage()) {
      this.errorMessage = other.errorMessage;
    }
  }

  public StreamLogs deepCopy() {
    return new StreamLogs(this);
  }

  @Override
  public void clear() {
    this.slaveStream = null;
    this.logLineBatches = null;
    this.errorMessage = null;
  }

  public SlaveStream getSlaveStream() {
    return this.slaveStream;
  }

  public StreamLogs setSlaveStream(SlaveStream slaveStream) {
    this.slaveStream = slaveStream;
    return this;
  }

  public void unsetSlaveStream() {
    this.slaveStream = null;
  }

  /** Returns true if field slaveStream is set (has been assigned a value) and false otherwise */
  public boolean isSetSlaveStream() {
    return this.slaveStream != null;
  }

  public void setSlaveStreamIsSet(boolean value) {
    if (!value) {
      this.slaveStream = null;
    }
  }

  public int getLogLineBatchesSize() {
    return (this.logLineBatches == null) ? 0 : this.logLineBatches.size();
  }

  public java.util.Iterator<LogLineBatch> getLogLineBatchesIterator() {
    return (this.logLineBatches == null) ? null : this.logLineBatches.iterator();
  }

  public void addToLogLineBatches(LogLineBatch elem) {
    if (this.logLineBatches == null) {
      this.logLineBatches = new ArrayList<LogLineBatch>();
    }
    this.logLineBatches.add(elem);
  }

  public List<LogLineBatch> getLogLineBatches() {
    return this.logLineBatches;
  }

  public StreamLogs setLogLineBatches(List<LogLineBatch> logLineBatches) {
    this.logLineBatches = logLineBatches;
    return this;
  }

  public void unsetLogLineBatches() {
    this.logLineBatches = null;
  }

  /** Returns true if field logLineBatches is set (has been assigned a value) and false otherwise */
  public boolean isSetLogLineBatches() {
    return this.logLineBatches != null;
  }

  public void setLogLineBatchesIsSet(boolean value) {
    if (!value) {
      this.logLineBatches = null;
    }
  }

  public String getErrorMessage() {
    return this.errorMessage;
  }

  public StreamLogs setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  public void unsetErrorMessage() {
    this.errorMessage = null;
  }

  /** Returns true if field errorMessage is set (has been assigned a value) and false otherwise */
  public boolean isSetErrorMessage() {
    return this.errorMessage != null;
  }

  public void setErrorMessageIsSet(boolean value) {
    if (!value) {
      this.errorMessage = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SLAVE_STREAM:
      if (value == null) {
        unsetSlaveStream();
      } else {
        setSlaveStream((SlaveStream)value);
      }
      break;

    case LOG_LINE_BATCHES:
      if (value == null) {
        unsetLogLineBatches();
      } else {
        setLogLineBatches((List<LogLineBatch>)value);
      }
      break;

    case ERROR_MESSAGE:
      if (value == null) {
        unsetErrorMessage();
      } else {
        setErrorMessage((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SLAVE_STREAM:
      return getSlaveStream();

    case LOG_LINE_BATCHES:
      return getLogLineBatches();

    case ERROR_MESSAGE:
      return getErrorMessage();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SLAVE_STREAM:
      return isSetSlaveStream();
    case LOG_LINE_BATCHES:
      return isSetLogLineBatches();
    case ERROR_MESSAGE:
      return isSetErrorMessage();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof StreamLogs)
      return this.equals((StreamLogs)that);
    return false;
  }

  public boolean equals(StreamLogs that) {
    if (that == null)
      return false;

    boolean this_present_slaveStream = true && this.isSetSlaveStream();
    boolean that_present_slaveStream = true && that.isSetSlaveStream();
    if (this_present_slaveStream || that_present_slaveStream) {
      if (!(this_present_slaveStream && that_present_slaveStream))
        return false;
      if (!this.slaveStream.equals(that.slaveStream))
        return false;
    }

    boolean this_present_logLineBatches = true && this.isSetLogLineBatches();
    boolean that_present_logLineBatches = true && that.isSetLogLineBatches();
    if (this_present_logLineBatches || that_present_logLineBatches) {
      if (!(this_present_logLineBatches && that_present_logLineBatches))
        return false;
      if (!this.logLineBatches.equals(that.logLineBatches))
        return false;
    }

    boolean this_present_errorMessage = true && this.isSetErrorMessage();
    boolean that_present_errorMessage = true && that.isSetErrorMessage();
    if (this_present_errorMessage || that_present_errorMessage) {
      if (!(this_present_errorMessage && that_present_errorMessage))
        return false;
      if (!this.errorMessage.equals(that.errorMessage))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_slaveStream = true && (isSetSlaveStream());
    list.add(present_slaveStream);
    if (present_slaveStream)
      list.add(slaveStream);

    boolean present_logLineBatches = true && (isSetLogLineBatches());
    list.add(present_logLineBatches);
    if (present_logLineBatches)
      list.add(logLineBatches);

    boolean present_errorMessage = true && (isSetErrorMessage());
    list.add(present_errorMessage);
    if (present_errorMessage)
      list.add(errorMessage);

    return list.hashCode();
  }

  @Override
  public int compareTo(StreamLogs other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSlaveStream()).compareTo(other.isSetSlaveStream());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSlaveStream()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.slaveStream, other.slaveStream);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLogLineBatches()).compareTo(other.isSetLogLineBatches());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLogLineBatches()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.logLineBatches, other.logLineBatches);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetErrorMessage()).compareTo(other.isSetErrorMessage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrorMessage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errorMessage, other.errorMessage);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("StreamLogs(");
    boolean first = true;

    if (isSetSlaveStream()) {
      sb.append("slaveStream:");
      if (this.slaveStream == null) {
        sb.append("null");
      } else {
        sb.append(this.slaveStream);
      }
      first = false;
    }
    if (isSetLogLineBatches()) {
      if (!first) sb.append(", ");
      sb.append("logLineBatches:");
      if (this.logLineBatches == null) {
        sb.append("null");
      } else {
        sb.append(this.logLineBatches);
      }
      first = false;
    }
    if (isSetErrorMessage()) {
      if (!first) sb.append(", ");
      sb.append("errorMessage:");
      if (this.errorMessage == null) {
        sb.append("null");
      } else {
        sb.append(this.errorMessage);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (slaveStream != null) {
      slaveStream.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class StreamLogsStandardSchemeFactory implements SchemeFactory {
    public StreamLogsStandardScheme getScheme() {
      return new StreamLogsStandardScheme();
    }
  }

  private static class StreamLogsStandardScheme extends StandardScheme<StreamLogs> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, StreamLogs struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SLAVE_STREAM
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.slaveStream = new SlaveStream();
              struct.slaveStream.read(iprot);
              struct.setSlaveStreamIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // LOG_LINE_BATCHES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list16 = iprot.readListBegin();
                struct.logLineBatches = new ArrayList<LogLineBatch>(_list16.size);
                LogLineBatch _elem17;
                for (int _i18 = 0; _i18 < _list16.size; ++_i18)
                {
                  _elem17 = new LogLineBatch();
                  _elem17.read(iprot);
                  struct.logLineBatches.add(_elem17);
                }
                iprot.readListEnd();
              }
              struct.setLogLineBatchesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ERROR_MESSAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.errorMessage = iprot.readString();
              struct.setErrorMessageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, StreamLogs struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.slaveStream != null) {
        if (struct.isSetSlaveStream()) {
          oprot.writeFieldBegin(SLAVE_STREAM_FIELD_DESC);
          struct.slaveStream.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.logLineBatches != null) {
        if (struct.isSetLogLineBatches()) {
          oprot.writeFieldBegin(LOG_LINE_BATCHES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.logLineBatches.size()));
            for (LogLineBatch _iter19 : struct.logLineBatches)
            {
              _iter19.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.errorMessage != null) {
        if (struct.isSetErrorMessage()) {
          oprot.writeFieldBegin(ERROR_MESSAGE_FIELD_DESC);
          oprot.writeString(struct.errorMessage);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class StreamLogsTupleSchemeFactory implements SchemeFactory {
    public StreamLogsTupleScheme getScheme() {
      return new StreamLogsTupleScheme();
    }
  }

  private static class StreamLogsTupleScheme extends TupleScheme<StreamLogs> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, StreamLogs struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSlaveStream()) {
        optionals.set(0);
      }
      if (struct.isSetLogLineBatches()) {
        optionals.set(1);
      }
      if (struct.isSetErrorMessage()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetSlaveStream()) {
        struct.slaveStream.write(oprot);
      }
      if (struct.isSetLogLineBatches()) {
        {
          oprot.writeI32(struct.logLineBatches.size());
          for (LogLineBatch _iter20 : struct.logLineBatches)
          {
            _iter20.write(oprot);
          }
        }
      }
      if (struct.isSetErrorMessage()) {
        oprot.writeString(struct.errorMessage);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, StreamLogs struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.slaveStream = new SlaveStream();
        struct.slaveStream.read(iprot);
        struct.setSlaveStreamIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list21 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.logLineBatches = new ArrayList<LogLineBatch>(_list21.size);
          LogLineBatch _elem22;
          for (int _i23 = 0; _i23 < _list21.size; ++_i23)
          {
            _elem22 = new LogLineBatch();
            _elem22.read(iprot);
            struct.logLineBatches.add(_elem22);
          }
        }
        struct.setLogLineBatchesIsSet(true);
      }
      if (incoming.get(2)) {
        struct.errorMessage = iprot.readString();
        struct.setErrorMessageIsSet(true);
      }
    }
  }

}

