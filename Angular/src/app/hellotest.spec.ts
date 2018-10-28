

//name of test 
describe('Test',()=>{
    let expected = '';
    beforeEach(()=>{
        expected ='hellotest';
    });

    it('checks if hellotest is hellotest',()=> expect('hellotest').toBe(expected));
    it('checks if hellotest is not hellotest',()=> expect('hellotest').not.toBe('hellotest1S'))


});