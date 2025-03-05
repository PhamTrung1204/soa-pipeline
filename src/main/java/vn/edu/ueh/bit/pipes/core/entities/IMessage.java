package vn.edu.ueh.bit.pipes.core.entities;

public interface IMessage {
    Object getPayload();
    void setPayload(Object payload);
    boolean isSuccess();
    void setSuccess(boolean success);
    String getMessage();
    void setMessage(String message);
}
