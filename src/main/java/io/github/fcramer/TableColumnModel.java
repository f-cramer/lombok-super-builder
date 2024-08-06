package io.github.fcramer;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public class TableColumnModel<RowType, ColumnType> {

	private String title;
	private RowType row;
	private ColumnType column;

	public static abstract class TableColumnModelBuilder<RowType, ColumnType, C extends TableColumnModel<RowType, ColumnType>, B extends TableColumnModelBuilder<RowType, ColumnType, C, B>> {

		public B titleSequence(CharSequence title) {
			return title(title != null ? title.toString() : null);
		}
	}

	@RequiredArgsConstructor
	public static class ColumnBuilder<RowType> {

		public <ColumnType> TableColumnModelBuilder<RowType, ColumnType, ?, ?> column(String title) {
			TableColumnModelBuilder<RowType, ColumnType, ?, ?> builder = TableColumnModel.<RowType, ColumnType>builder();
			return builder
					.title(title);
		}
	}
}
