package vn.edu.ueh.bit.pipes.pipes;

import vn.edu.ueh.bit.pipes.core.entities.IFilter;
import vn.edu.ueh.bit.pipes.core.entities.IMessage;

public class Pipeline extends PipelineBase {
    @Override
    public IMessage process(IMessage message) {
        if (message == null) return null;

        IMessage result = message;
        for (IFilter filter : filters) {
            if (filter.isMatch(result)) {
                result = filter.execute(result);
                // If any filter fails, stop the pipeline
                if (!result.isSuccess()) {
                    break;
                }
            }
        }
        return result;
    }
}
