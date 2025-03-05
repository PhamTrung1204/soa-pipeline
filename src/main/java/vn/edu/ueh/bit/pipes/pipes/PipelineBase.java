package vn.edu.ueh.bit.pipes.pipes;

import vn.edu.ueh.bit.pipes.core.entities.IFilter;
import vn.edu.ueh.bit.pipes.core.entities.IMessage;

import java.util.ArrayList;
import java.util.List;

public abstract class PipelineBase {
    protected List<IFilter> filters = new ArrayList<>();

    public void addFilter(IFilter filter) {
        filters.add(filter);
    }

    public abstract IMessage process(IMessage message);
}
