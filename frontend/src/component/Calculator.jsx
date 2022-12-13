import { Fragment,useState } from "react"
import axios from 'axios'
const Calculator=()=>{
    const [count, setCount] = useState(0)
const possibleOperations=["+","*","-","ln","/","**"]
const [op1,setOp1]=useState(null);
const [op2,setOp2]=useState(null);
const [operation,setOperation]=useState("+");
const [result,setResult]=useState(null)
const handleCalculate=async()=>{
console.log(op1+op2);
const body={operand1:op1,operand2:op2,operation}
const resp=await axios.post("/math",body);
console.log(operation);
setResult(resp.data)
console.log(resp);
}
    return(
        <Fragment>
             <input type="number" className='operand' value={op1} onChange={(e)=>setOp1(e.target.value)} data-testid = "operand" id="operand1"/>
      <select name="" className="operation" data-testid="operation" onChange={(e)=>setOperation(e.target.value)} id="operation">
        {possibleOperations.map((operation,idx)=>(
          <option key={idx} value={operation} onChange={(e)=>setOperation(e.target.value)} >{operation}</option>
        ))}
      </select>
      <input type="number" className='operand' value={op2} id="operand2" onChange={(e)=>setOp2(e.target.value)}/>
      <button className='submit' onClick={handleCalculate} id="button" data-testid="button">calculate</button>
      {result!=null?<span id="result" className='result'>The result is: {result}</span>:null}
        </Fragment>
    )
}
export default Calculator