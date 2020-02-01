//Retorna el mayor valor del arreglo
function returnLargest(arr) {
    var mayor = arr[0];
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] > mayor)
            mayor = arr[i];
    }
    return mayor;
}

describe("returnLargest", function () {
    it("should return 3 when we pass [0,1,2,3] as an argument", function () {
        expect(returnLargest([0, 1, 2, 3])).toEqual(3);
    });
    it("should return -6 when we pass [-11,-7,-6] as an argument", function () {
        expect(returnLargest([-11, -7, -6])).toEqual(-6);
    });
});