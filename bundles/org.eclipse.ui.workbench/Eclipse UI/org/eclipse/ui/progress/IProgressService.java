/**********************************************************************
 * Copyright (c) 2003 IBM Corporation and others. All rights reserved.   This
 * program and the accompanying materials are made available under the terms of
 * the Common Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors: 
 * IBM - Initial API and implementation
 **********************************************************************/
package org.eclipse.ui.progress;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;

/**
 * The IProgressManager is an interface to the progress manager provided by the
 * workbench. <b>NOTE: This is experimental API and subject to change at any
 * time</b>.
 * 
 * @since 3.0
 */
public interface IProgressService extends IRunnableContext {

	/**
	 * The time at which the busy cursor will be replaced with a progress
	 * monitor.
	 */
	public int LONG_OPERATION_MILLISECONDS = 5000;

	/**
	 * Set the cursor to busy and run runnable within the UI Thread. After the
	 * cursor has been running for LONG_OPERATION_MILLISECONDS replace it with
	 * a ProgressMonitorDialog so that the user may cancel.
	 * Do not open the ProgressMonitorDialog if there is already a modal
	 * dialog open.
	 * 
	 * @param runnable
	 */
	public void busyCursorWhile(IRunnableWithProgress runnable)
		throws InvocationTargetException, InterruptedException;
	
	/**
	 * @deprecated. @see showInDialog(Shell,Job).
	 */
	public void showInDialog(Shell shell, Job job, boolean runImmediately);
	
	/**
	 * Open a dialog on job when it starts to run and close it 
	 * when the job is finished. Wait for LONG_OPERATION_MILLISECONDS
	 * before opening the dialog. Do not open if it is already done.
	 * 
	 * Parent the dialog from the shell.
	 * 
	 * @param job The Job that will be reported in the dialog.
	 * @param shell The Shell to parent the dialog from or 
	 * <code>null</code> if the active shell is to be used.
	 */
	public void showInDialog(Shell shell, Job job);

}
