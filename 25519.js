"use strict";

var fs = require("fs");
var sodium = require('libsodium-wrappers');
var kp = sodium.crypto_box_keypair();
fs.writeFileSync("/tmp/prikey.sodium", new Buffer(kp.privateKey));
fs.writeFileSync("/tmp/pubkey.sodium", new Buffer(kp.publicKey));

var plaintext = sodium.randombytes_buf(16);
var ciphertext = sodium.crypto_box_seal(plaintext, kp.publicKey);
fs.writeFileSync("/tmp/ciphertext.sodium", new Buffer(ciphertext));
