var should = require('chai').should();
var expect = require('chai').expect;
var supertest = require('supertest');
var client = supertest('http://localhost:8081');

describe('User v1', function () {

    before(function (done) {

        done();
    });

    it('should return a 200 response', function (done) {
        client.get('/api/user/9febab1c-6f36-4a0b-88d6-3b6a6d81cd4a')
            .set('Accept', 'application/vnd.user.api.v1+json')
            .set('Content-Type', 'application/vnd.user.api.v1+json')
            .expect(200, done);
    });

    it('should be an object with keys and values', function (done) {
        client.get('/api/user/9febab1c-6f36-4a0b-88d6-3b6a6d81cd4a')
            .set('Accept', 'application/vnd.user.api.v1+json')
            .set('Content-Type', 'application/vnd.user.api.v1+json')
            .expect(200)
            .end(function (err, res) {
                expect(res.body).to.have.property("email");
                expect(res.body.email).to.not.equal(null);
                expect(res.body).to.have.property("firstName");
                expect(res.body.firstName).to.not.equal(null);
                expect(res.body).to.have.property("lastName");
                expect(res.body.lastName).to.not.equal(null);
                done();
            });
    });


});