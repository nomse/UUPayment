/*
 * Copyright (c) 2010-2017 Nathan Rajlich
 *
 *  Permission is hereby granted, free of charge, to any person
 *  obtaining a copy of this software and associated documentation
 *  files (the "Software"), to deal in the Software without
 *  restriction, including without limitation the rights to use,
 *  copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the
 *  Software is furnished to do so, subject to the following
 *  conditions:
 *
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 *  OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 *  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 *  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 *  OTHER DEALINGS IN THE SOFTWARE.
 */

package com.unionpay.payment.carpay.activity;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Collections;

import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import android.util.Log;


public class AutobahnServerTest extends WebSocketServer {
	public String ll;
	public void setLl(String ll) {
		this.ll = ll;
	}

	public AutobahnServerTest( int port, Draft d ) throws UnknownHostException {
		super( new InetSocketAddress( port ), Collections.singletonList( d ) );
	}

	public AutobahnServerTest( InetSocketAddress address, Draft d ) {
		super( address, Collections.singletonList( d ) );
	}
	@Override
	public void onOpen( WebSocket conn, ClientHandshake handshake ) {
	}

	@Override
	public void onClose( WebSocket conn, int code, String reason, boolean remote ) {
	}

	@Override
	public void onError( WebSocket conn, Exception ex ) {
		ex.printStackTrace();
	}

	@Override
	public void onStart() {
	}

	@Override
	public void onMessage( WebSocket conn, String message ) {
		Log.e("webservice", "++++++++onmessage"+ll);
		conn.send( ll );
	}

	@Override
	public void onMessage( WebSocket conn, ByteBuffer blob ) {
		conn.send( blob );
	}

	@Override
	public void onWebsocketMessageFragment( WebSocket conn, Framedata frame ) {
		FramedataImpl1 builder = ( FramedataImpl1 ) frame;
		builder.setTransferemasked( false );
		conn.sendFrame( frame );
	}

	public static void main( String[] args ) throws UnknownHostException {
		WebSocketImpl.DEBUG = false;
		AutobahnServerTest test = new AutobahnServerTest(54300, new Draft_6455());
		test.setConnectionLostTimeout( 0 );
		test.start();
	}

}
