
describe("add company mock tests",()=>{
    beforeEach(()=>{
        cy.visit('http://127.0.0.1:5173')
    })
    it('test calculator',()=>{
        cy.get("#operand1").type(2);
        cy.get("#operand2").type(10);
        cy.get("operation").type("+")
        cy.get("#button").click()
        //mocking http request
        cy.intercept("POST","http://localhost:8080/company",(req)=>{
            req.reply((res)=>{
                res.send({
                        "operand1": 10,
                        "operand2": 10,
                        "operation": "*",
                })
            })
        })
        cy.get("#result").contains(12)   
    })
})