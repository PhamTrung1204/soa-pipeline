package vn.edu.ueh.bit.pipes.core.entities;

public interface IFilter {
    boolean isMatch(IMessage message);
    IMessage execute(IMessage message);
}
