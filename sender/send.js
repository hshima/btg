const amqplib = require('amqplib/callback_api');
const queue = 'btg-challenge';
const connection_params = {
    protocol: 'amqp',
    hostname: 'localhost',
    // hostname: 'host.containers.internal',
    port: 5672,
    username: "myuser",
    password: "secret"
};
const obj = {
    "codigoPedido": 1001,
    "codigoCliente": 1,
    "itens": [
        {
            "produto": "lápis",
            "quantidade": 100,
            "preco": 1.10
        },
        {
            "produto": "caderno",
            "quantidade": 10,
            "preco": 1.00
        }
    ]
};

const listen = (conn) => {
    conn.createChannel((err, ch2) => {
        if (err) throw err;

        ch2.assertQueue(queue);

        ch2.consume(queue, (msg) => {
            if (msg !== null) {
                console.log(msg.content.toString());
                ch2.ack(msg);
            } else {
                console.log('Consumer cancelled by server');
            }
        });
    });
};

const send = (conn, msg) => {
    conn.createChannel((err, ch1) => {
        if (err) throw err;
        ch1.assertQueue(queue);
        setInterval(() => {
            ch1.sendToQueue(queue, Buffer.from(msg));
        }, 1000);
    });
};

amqplib.connect(connection_params, (err, conn) => {
    if (err) throw err;
    send(conn, JSON.stringify(obj));
});
