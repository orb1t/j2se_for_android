/*
 * Copyright (c) 1999, 2007, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package java.awt.event;

import java.awt.Component;

/**
 * A low-level event which indicates that a Component has gained or lost the
 * input focus. This low-level event is generated by a Component (such as a
 * TextField). The event is passed to every <code>FocusListener</code> or
 * <code>FocusAdapter</code> object which registered to receive such events
 * using the Component's <code>addFocusListener</code> method. (<code>
 * FocusAdapter</code> objects implement the <code>FocusListener</code>
 * interface.) Each such listener object gets this <code>FocusEvent</code> when
 * the event occurs.
 * <p>
 * There are two levels of focus events: permanent and temporary. Permanent
 * focus change events occur when focus is directly moved from one Component to
 * another, such as through a call to requestFocus() or as the user uses the TAB
 * key to traverse Components. Temporary focus change events occur when focus is
 * temporarily lost for a Component as the indirect result of another operation,
 * such as Window deactivation or a Scrollbar drag. In this case, the original
 * focus state will automatically be restored once that operation is finished,
 * or, for the case of Window deactivation, when the Window is reactivated. Both
 * permanent and temporary focus events are delivered using the FOCUS_GAINED and
 * FOCUS_LOST event ids; the level may be distinguished in the event using the
 * isTemporary() method.
 * <p>
 * An unspecified behavior will be caused if the {@code id} parameter of any
 * particular {@code FocusEvent} instance is not in the range from
 * {@code FOCUS_FIRST} to {@code FOCUS_LAST}.
 *
 * @see FocusAdapter
 * @see FocusListener
 * @see <a href=
 *      "http://java.sun.com/docs/books/tutorial/post1.0/ui/focuslistener.html">Tutorial:
 *      Writing a Focus Listener</a>
 *
 * @author Carl Quinn
 * @author Amy Fowler
 * @since 1.1
 */
public class FocusEvent extends ComponentEvent {
	public static final int FOCUS_FIRST = 1004;
	public static final int FOCUS_LAST = 1005;
	public static final int FOCUS_GAINED = FOCUS_FIRST;
	public static final int FOCUS_LOST = 1 + FOCUS_FIRST;

	boolean temporary;
	transient Component opposite;

	public FocusEvent(Component source, int id, boolean temporary, Component opposite) {
		super(source, id);
		this.temporary = temporary;
		this.opposite = opposite;
	}

	public FocusEvent(Component source, int id, boolean temporary) {
		this(source, id, temporary, null);
	}

	public FocusEvent(Component source, int id) {
		this(source, id, false);
	}

	public boolean isTemporary() {
		return temporary;
	}

	public Component getOppositeComponent() {
		if (opposite == null) {
			return null;
		}

		return null;
	}

	public String paramString() {
		return "FocusEvent id:" + id + (temporary ? ",temporary" : ",permanent") + ",opposite="
				+ getOppositeComponent();
	}

}
