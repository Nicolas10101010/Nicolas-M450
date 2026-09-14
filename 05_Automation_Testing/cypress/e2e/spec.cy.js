describe("Automated Tests", () => {
  beforeEach(() => {
    cy.visit("http://localhost:4200/");
  });

  it("should load the page", () => {
    cy.contains("List Students").should("be.visible");
  });

  it("should navigate to the students page", () => {
    cy.get('[data-cy="list-students"]').click();
    cy.url().should("include", "/students");
  });

  it("should add a student and show it in the list", () => {
    cy.get('[data-cy="add-student"]').click();
    cy.get('[data-cy="student-name"]').type("John Doe");
    cy.get('[data-cy="student-email"]').type("john.doe@example.com");
    cy.get('[data-cy="submit-student"]').click();

    cy.url().should("include", "/students");
    cy.contains("John Doe").should("be.visible");
  });
});
