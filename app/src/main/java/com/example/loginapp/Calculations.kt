package com.example.loginapp

class Calculations (var v_values:ArrayList<Any>){
    var output=0.0
    var count=0
    fun Add_Function():Double
    {
        for(v_val in v_values)
        {
            output=output + v_val.toString().toDouble()
        }
        return output
    }
    fun Sub_Function():Double
    {
        for(v_val in v_values)
        {
            if (count==0)
            {
                output=v_val.toString().toDouble()
                count+=1
            }
            else
            {
                output=output-v_val.toString().toDouble()
            }

        }
        return output
    }
}