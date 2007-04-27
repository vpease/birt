/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.item.crosstab.core.de;

import java.util.List;
import java.util.logging.Level;

import org.eclipse.birt.report.item.crosstab.core.CrosstabException;
import org.eclipse.birt.report.item.crosstab.core.ICrosstabConstants;
import org.eclipse.birt.report.item.crosstab.core.ICrosstabReportItemConstants;
import org.eclipse.birt.report.item.crosstab.core.ICrosstabViewConstants;
import org.eclipse.birt.report.item.crosstab.core.de.internal.CrosstabViewTask;
import org.eclipse.birt.report.item.crosstab.core.i18n.MessageConstants;
import org.eclipse.birt.report.item.crosstab.core.util.CrosstabExtendedItemFactory;
import org.eclipse.birt.report.item.crosstab.core.util.CrosstabUtil;
import org.eclipse.birt.report.model.api.DesignElementHandle;
import org.eclipse.birt.report.model.api.ExtendedItemHandle;
import org.eclipse.birt.report.model.api.PropertyHandle;
import org.eclipse.birt.report.model.api.activity.SemanticException;
import org.eclipse.birt.report.model.api.olap.DimensionHandle;

/**
 * CrosstabViewHandle.
 */
public class CrosstabViewHandle extends AbstractCrosstabItemHandle implements
		ICrosstabViewConstants,
		ICrosstabConstants
{

	/**
	 * 
	 * @param element
	 */
	protected CrosstabViewHandle( DesignElementHandle element )
	{
		super( element );
	}

	/**
	 * Returns if current level is mirrored
	 * 
	 * @return
	 */
	public boolean isMirrored( )
	{
		return handle.getBooleanProperty( MIRRORED_PROP );
	}

	/**
	 * Sets mirrrored property for current level.
	 * 
	 * @param value
	 * @throws SemanticException
	 */
	public void setMirrored( boolean value ) throws SemanticException
	{
		handle.setProperty( MIRRORED_PROP, Boolean.valueOf( value ) );
	}

	/**
	 * Gets the property handle for grand total.
	 * 
	 * @return grand total property handle
	 */
	public PropertyHandle getGrandTotalProperty( )
	{
		return handle.getPropertyHandle( GRAND_TOTAL_PROP );
	}

	/**
	 * Gets the property handle for dimension views.
	 * 
	 * @return dimension views property handle.
	 */
	public PropertyHandle getViewsProperty( )
	{
		return handle.getPropertyHandle( VIEWS_PROP );
	}

	/**
	 * Finds a dimension view that refers a cube dimension element with the
	 * given name.
	 * 
	 * @param name
	 *            name of the cube dimension element to find
	 * @return dimension view if found, otherwise null
	 */
	public DimensionViewHandle getDimension( String name )
	{
		for ( int i = 0; i < getDimensionCount( ); i++ )
		{
			DimensionViewHandle dimensionView = getDimension( i );
			if ( dimensionView != null )
			{
				String cubeDimensionName = dimensionView.getCubeDimensionName( );
				if ( ( cubeDimensionName != null && cubeDimensionName.equals( name ) )
						|| ( cubeDimensionName == null && name == null ) )
					return dimensionView;
			}
		}
		return null;
	}

	/**
	 * Gets the dimension view with the given index.Index is 0-based integer.
	 * 
	 * @param index
	 *            a 0-based integer of the dimension position
	 * @return the dimension view handle if found, otherwise null
	 */
	public DimensionViewHandle getDimension( int index )
	{

		DesignElementHandle element = getViewsProperty( ).getContent( index );
		return (DimensionViewHandle) CrosstabUtil.getReportItem( element,
				DIMENSION_VIEW_EXTENSION_NAME );

	}

	/**
	 * Gets the dimension view count.
	 * 
	 * @return count of dimension views
	 */
	public int getDimensionCount( )
	{
		return getViewsProperty( ).getContentCount( );
	}

	/**
	 * Inserts a dimension into the given position. Index is 0-based integer.
	 * 
	 * @param dimensionHandle
	 *            the OLAP dimension handle to use
	 * @param index
	 *            insert position, a 0-based integer
	 * @return
	 * @throws SemanticException
	 */
	public DimensionViewHandle insertDimension(
			DimensionHandle dimensionHandle, int index )
			throws SemanticException
	{
		ExtendedItemHandle extendedItem = CrosstabExtendedItemFactory.createDimensionView( moduleHandle,
				dimensionHandle );
		if ( extendedItem == null )
			return null;
		// if this dimension handle has referred by an existing dimension view,
		// then log error and do nothing
		if ( dimensionHandle != null
				&& getDimension( dimensionHandle.getQualifiedName( ) ) != null )
		{
			logger.log( Level.SEVERE,
					MessageConstants.CROSSTAB_EXCEPTION_DUPLICATE_DIMENSION,
					dimensionHandle.getQualifiedName( ) );
			throw new CrosstabException( handle.getElement( ), new String[]{
					dimensionHandle.getQualifiedName( ),
					handle.getElement( ).getIdentifier( )
			}, MessageConstants.CROSSTAB_EXCEPTION_DUPLICATE_DIMENSION );
		}
		getViewsProperty( ).add( extendedItem, index );
		return (DimensionViewHandle) CrosstabUtil.getReportItem( extendedItem );
	}

	/**
	 * Removes a dimension view that refers a cube dimension name with the given
	 * name from the design tree.
	 * 
	 * @param name
	 *            name of the dimension view to remove
	 * @throws SemanticException
	 */
	public void removeDimension( String name ) throws SemanticException
	{
		new CrosstabViewTask( this ).removeDimension( name );
	}

	/**
	 * Removes a dimension view in the given position. Index is 0-based integer.
	 * 
	 * @param index
	 *            the position index of the dimension to remove, 0-based integer
	 * @throws SemanticException
	 */
	public void removeDimension( int index ) throws SemanticException
	{
		new CrosstabViewTask( this ).removeDimension( index );
	}

	/**
	 * Gets the grand total cell of this crosstab view.
	 * 
	 * @return row/column grand total cell if set, otherwise null
	 */
	public CrosstabCellHandle getGrandTotal( )
	{
		PropertyHandle propHandle = getGrandTotalProperty( );
		return propHandle.getContentCount( ) == 0 ? null
				: (CrosstabCellHandle) CrosstabUtil.getReportItem( propHandle.getContent( 0 ),
						CROSSTAB_CELL_EXTENSION_NAME );
	}

	/**
	 * Adds grand-total for this crosstab view.
	 * 
	 * @param measureList
	 * @param functionList
	 * @return
	 * @throws SemanticException
	 */
	public CrosstabCellHandle addGrandTotal( List measureList, List functionList )
			throws SemanticException
	{
		return new CrosstabViewTask( this ).addGrandTotal( measureList,
				functionList );
	}

	/**
	 * Removes grand total from crosstab if it is not empty, otherwise do
	 * nothing.
	 */
	public void removeGrandTotal( ) throws SemanticException
	{
		new CrosstabViewTask( this ).removeGrandTotal( );
	}

	/**
	 * Remove grand total on particular measure
	 */
	public void removeGrandTotal( int measureIndex ) throws SemanticException
	{
		new CrosstabViewTask( this ).removeGrandTotal( measureIndex );
	}

	/**
	 * Gets the axis type of this crosstab view in the crosstab. If this view
	 * lies in the design tree, the returned value is either
	 * <code>ICrosstabConstants.ROW_AXIS_TYPE</code> or
	 * <code>ICrosstabConstants.COLUMN_AXIS_TYPE</code>. Otherwise return
	 * <code>ICrosstabConstants.NO_AXIS_TYPE</code>.
	 * 
	 * @return the axis type if this crosstab view resides in design tree,
	 *         otherwise -1;
	 */
	public int getAxisType( )
	{
		PropertyHandle propHandle = handle.getContainerPropertyHandle( );
		if ( propHandle == null )
			return NO_AXIS_TYPE;
		String propName = propHandle.getPropertyDefn( ).getName( );
		if ( ICrosstabReportItemConstants.ROWS_PROP.equals( propName ) )
			return ROW_AXIS_TYPE;
		if ( ICrosstabReportItemConstants.COLUMNS_PROP.equals( propName ) )
			return COLUMN_AXIS_TYPE;
		return NO_AXIS_TYPE;

	}

}
