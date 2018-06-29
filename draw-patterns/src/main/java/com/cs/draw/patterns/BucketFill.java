package com.cs.draw.patterns;


import com.cs.draw.constants.FloodFill;
import com.cs.draw.constants.Input;
import com.cs.draw.exception.ApplicationException;
import com.cs.draw.processor.Context;

@Input(
        size = 3,
        msg = "BucketFill creation input pattern : B x<int>  y<int> c<String> [eg: B 3 4 c] "
)
public class BucketFill  extends Pattern{

    String c;

    public BucketFill(String... args) throws ApplicationException {
        super(args);
        this.x=new Integer[]{Integer.parseInt(args[0])};
        this.y=new Integer[]{Integer.parseInt(args[1])};
        this.c = args[2];
    }

    @Override
    public void validate(Context context) throws ApplicationException {

    }

    @Override
    public void build(Context context) throws ApplicationException {
        FloodFill f = new FloodFill();
        f.apply(context.getCtx(), this.getColorToReplace(context.getCtx()), this.c, this.y[0], this.x[0]);

    }

    private String getColorToReplace(String[][] data) {
        return data[y[0]][x[0]];
    }
}
