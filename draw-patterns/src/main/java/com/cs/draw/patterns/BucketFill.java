package com.cs.draw.patterns;

import com.cs.draw.helper.ApplicationException;
import com.cs.draw.helper.FloodFill;
import com.cs.draw.helper.Input;

import java.util.List;


/***
 * BucketFill class instance is created for pattern to fill given character .
 *
 *
 * B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
 * behaviour of this is the same as that of the "bucket fill" tool in paint
 * programs.
 *
 *
 */

@Input(
        inputSize = 3,
        types = {Input.Type.INT, Input.Type.INT, Input.Type.STRING},
        msg = "BucketFill creation input pattern : B x<int>  y<int> c<String> [eg: B 3 4 c] "
)
public class BucketFill extends Pattern {


    String c;

    public BucketFill(String[] params) {
        super(params);
    }

    @Override
    public List<List<String>> build(List<List<String>> data) throws ApplicationException {
        FloodFill f = new FloodFill();
        data = f.apply(data, this.getColorToReplace(data), this.c, this.y[0], this.x[0]);
        return data;
    }

    private String getColorToReplace(List<List<String>> data) {
        return data.get(this.y[0]).get(this.x[0]);
    }


    @Override
    public void processParams() {
        this.x=new Integer[]{Integer.parseInt(params[0])};
        this.y=new Integer[]{Integer.parseInt(params[1])};
        this.c = params[2];
    }

    @Override
    public void validateParams(List<List<String>> data) throws ApplicationException {
        validateY(data,this.y);
        validateX(data,this.x);
    }
}
