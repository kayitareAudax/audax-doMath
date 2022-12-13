describe('test calculator', () => {
    beforeEach(()=>{
      cy.visit(`http://127.0.0.1:5173/`)
    })
    it("tests add",(done)=>{
      cy.get("#operand1").type(2);
      cy.get("#operand2").type(10);
      cy.get("operation").type("+")
      cy.get("#button").click()
      cy.get("#result").contains(12)   
    })
  })