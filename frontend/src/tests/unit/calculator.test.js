import { fireEvent, render, screen } from "@testing-library/react";
import Calculator from "../../component/Calculator";

describe("<CalCulator/>", () => {
    test('render ', () => {
        render(<Calculator/>);
        const inputEl = screen.getByTestId("operand");
        let buttonEl = screen.getByTestId("button");
        expect(inputEl).toBeInTheDocument();
        expect(inputEl).toHaveAttribute("type", "number");
        expect(buttonEl).toBeInTheDocument()
    });
    test('have operands', () => {
        render(<Calculator/>);
        const inputEl = screen.getByTestId("operand");
        inputEl.textContent = 12
        expect(inputEl).toHaveTextContent(12)
    })
    test('have operation', () => {
        render(<Calculator/>);
        const inputEl = screen.getByTestId("operation");
        inputEl.textContent = "*"
        expect(inputEl).toHaveTextContent("*")
    })
})