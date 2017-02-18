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
public class MultiGetBuildSlaveLogDirRequest implements org.apache.thrift.TBase<MultiGetBuildSlaveLogDirRequest, MultiGetBuildSlaveLogDirRequest._Fields>, java.io.Serializable, Cloneable, Comparable<MultiGetBuildSlaveLogDirRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MultiGetBuildSlaveLogDirRequest");

  private static final org.apache.thrift.protocol.TField BUILD_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("buildId", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField RUN_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("runIds", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new MultiGetBuildSlaveLogDirRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new MultiGetBuildSlaveLogDirRequestTupleSchemeFactory());
  }

  public BuildId buildId; // optional
  public List<RunId> runIds; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BUILD_ID((short)1, "buildId"),
    RUN_IDS((short)2, "runIds");

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
        case 1: // BUILD_ID
          return BUILD_ID;
        case 2: // RUN_IDS
          return RUN_IDS;
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
  private static final _Fields optionals[] = {_Fields.BUILD_ID,_Fields.RUN_IDS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BUILD_ID, new org.apache.thrift.meta_data.FieldMetaData("buildId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, BuildId.class)));
    tmpMap.put(_Fields.RUN_IDS, new org.apache.thrift.meta_data.FieldMetaData("runIds", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RunId.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MultiGetBuildSlaveLogDirRequest.class, metaDataMap);
  }

  public MultiGetBuildSlaveLogDirRequest() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MultiGetBuildSlaveLogDirRequest(MultiGetBuildSlaveLogDirRequest other) {
    if (other.isSetBuildId()) {
      this.buildId = new BuildId(other.buildId);
    }
    if (other.isSetRunIds()) {
      List<RunId> __this__runIds = new ArrayList<RunId>(other.runIds.size());
      for (RunId other_element : other.runIds) {
        __this__runIds.add(new RunId(other_element));
      }
      this.runIds = __this__runIds;
    }
  }

  public MultiGetBuildSlaveLogDirRequest deepCopy() {
    return new MultiGetBuildSlaveLogDirRequest(this);
  }

  @Override
  public void clear() {
    this.buildId = null;
    this.runIds = null;
  }

  public BuildId getBuildId() {
    return this.buildId;
  }

  public MultiGetBuildSlaveLogDirRequest setBuildId(BuildId buildId) {
    this.buildId = buildId;
    return this;
  }

  public void unsetBuildId() {
    this.buildId = null;
  }

  /** Returns true if field buildId is set (has been assigned a value) and false otherwise */
  public boolean isSetBuildId() {
    return this.buildId != null;
  }

  public void setBuildIdIsSet(boolean value) {
    if (!value) {
      this.buildId = null;
    }
  }

  public int getRunIdsSize() {
    return (this.runIds == null) ? 0 : this.runIds.size();
  }

  public java.util.Iterator<RunId> getRunIdsIterator() {
    return (this.runIds == null) ? null : this.runIds.iterator();
  }

  public void addToRunIds(RunId elem) {
    if (this.runIds == null) {
      this.runIds = new ArrayList<RunId>();
    }
    this.runIds.add(elem);
  }

  public List<RunId> getRunIds() {
    return this.runIds;
  }

  public MultiGetBuildSlaveLogDirRequest setRunIds(List<RunId> runIds) {
    this.runIds = runIds;
    return this;
  }

  public void unsetRunIds() {
    this.runIds = null;
  }

  /** Returns true if field runIds is set (has been assigned a value) and false otherwise */
  public boolean isSetRunIds() {
    return this.runIds != null;
  }

  public void setRunIdsIsSet(boolean value) {
    if (!value) {
      this.runIds = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case BUILD_ID:
      if (value == null) {
        unsetBuildId();
      } else {
        setBuildId((BuildId)value);
      }
      break;

    case RUN_IDS:
      if (value == null) {
        unsetRunIds();
      } else {
        setRunIds((List<RunId>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case BUILD_ID:
      return getBuildId();

    case RUN_IDS:
      return getRunIds();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case BUILD_ID:
      return isSetBuildId();
    case RUN_IDS:
      return isSetRunIds();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MultiGetBuildSlaveLogDirRequest)
      return this.equals((MultiGetBuildSlaveLogDirRequest)that);
    return false;
  }

  public boolean equals(MultiGetBuildSlaveLogDirRequest that) {
    if (that == null)
      return false;

    boolean this_present_buildId = true && this.isSetBuildId();
    boolean that_present_buildId = true && that.isSetBuildId();
    if (this_present_buildId || that_present_buildId) {
      if (!(this_present_buildId && that_present_buildId))
        return false;
      if (!this.buildId.equals(that.buildId))
        return false;
    }

    boolean this_present_runIds = true && this.isSetRunIds();
    boolean that_present_runIds = true && that.isSetRunIds();
    if (this_present_runIds || that_present_runIds) {
      if (!(this_present_runIds && that_present_runIds))
        return false;
      if (!this.runIds.equals(that.runIds))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_buildId = true && (isSetBuildId());
    list.add(present_buildId);
    if (present_buildId)
      list.add(buildId);

    boolean present_runIds = true && (isSetRunIds());
    list.add(present_runIds);
    if (present_runIds)
      list.add(runIds);

    return list.hashCode();
  }

  @Override
  public int compareTo(MultiGetBuildSlaveLogDirRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetBuildId()).compareTo(other.isSetBuildId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBuildId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.buildId, other.buildId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRunIds()).compareTo(other.isSetRunIds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRunIds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.runIds, other.runIds);
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
    StringBuilder sb = new StringBuilder("MultiGetBuildSlaveLogDirRequest(");
    boolean first = true;

    if (isSetBuildId()) {
      sb.append("buildId:");
      if (this.buildId == null) {
        sb.append("null");
      } else {
        sb.append(this.buildId);
      }
      first = false;
    }
    if (isSetRunIds()) {
      if (!first) sb.append(", ");
      sb.append("runIds:");
      if (this.runIds == null) {
        sb.append("null");
      } else {
        sb.append(this.runIds);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (buildId != null) {
      buildId.validate();
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

  private static class MultiGetBuildSlaveLogDirRequestStandardSchemeFactory implements SchemeFactory {
    public MultiGetBuildSlaveLogDirRequestStandardScheme getScheme() {
      return new MultiGetBuildSlaveLogDirRequestStandardScheme();
    }
  }

  private static class MultiGetBuildSlaveLogDirRequestStandardScheme extends StandardScheme<MultiGetBuildSlaveLogDirRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MultiGetBuildSlaveLogDirRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BUILD_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.buildId = new BuildId();
              struct.buildId.read(iprot);
              struct.setBuildIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // RUN_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list98 = iprot.readListBegin();
                struct.runIds = new ArrayList<RunId>(_list98.size);
                RunId _elem99;
                for (int _i100 = 0; _i100 < _list98.size; ++_i100)
                {
                  _elem99 = new RunId();
                  _elem99.read(iprot);
                  struct.runIds.add(_elem99);
                }
                iprot.readListEnd();
              }
              struct.setRunIdsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, MultiGetBuildSlaveLogDirRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.buildId != null) {
        if (struct.isSetBuildId()) {
          oprot.writeFieldBegin(BUILD_ID_FIELD_DESC);
          struct.buildId.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.runIds != null) {
        if (struct.isSetRunIds()) {
          oprot.writeFieldBegin(RUN_IDS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.runIds.size()));
            for (RunId _iter101 : struct.runIds)
            {
              _iter101.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MultiGetBuildSlaveLogDirRequestTupleSchemeFactory implements SchemeFactory {
    public MultiGetBuildSlaveLogDirRequestTupleScheme getScheme() {
      return new MultiGetBuildSlaveLogDirRequestTupleScheme();
    }
  }

  private static class MultiGetBuildSlaveLogDirRequestTupleScheme extends TupleScheme<MultiGetBuildSlaveLogDirRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MultiGetBuildSlaveLogDirRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetBuildId()) {
        optionals.set(0);
      }
      if (struct.isSetRunIds()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetBuildId()) {
        struct.buildId.write(oprot);
      }
      if (struct.isSetRunIds()) {
        {
          oprot.writeI32(struct.runIds.size());
          for (RunId _iter102 : struct.runIds)
          {
            _iter102.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MultiGetBuildSlaveLogDirRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.buildId = new BuildId();
        struct.buildId.read(iprot);
        struct.setBuildIdIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list103 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.runIds = new ArrayList<RunId>(_list103.size);
          RunId _elem104;
          for (int _i105 = 0; _i105 < _list103.size; ++_i105)
          {
            _elem104 = new RunId();
            _elem104.read(iprot);
            struct.runIds.add(_elem104);
          }
        }
        struct.setRunIdsIsSet(true);
      }
    }
  }

}

