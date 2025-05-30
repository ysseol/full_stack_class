package page;

public class PageUtil {

	public static final int PAGE_SCALE = 10;
	public static final int BLOCK_SCALE = 10;

	private int curPage;
	private int totPage;
	private int pageBegin;
	private int pageEnd;
	private int blockStart;
	private int blockEnd;
	private int prevPage;
	private int nextPage;
	private int curBlock;
	private int totBlock;

	public PageUtil(int totalCount, int curPage) {
		this.curPage = curPage;
		this.totPage = (int) Math.ceil(totalCount / (double) PAGE_SCALE);
		this.totBlock = (int) Math.ceil(totPage / (double) BLOCK_SCALE);

		setPageRange();
		setBlockRange();
	}

	private void setPageRange() {
		pageBegin = (curPage - 1) * PAGE_SCALE + 1;
		pageEnd = Math.min(pageBegin + PAGE_SCALE - 1, totPage * PAGE_SCALE);
	}

	private void setBlockRange() {
		curBlock = (int) Math.ceil(curPage / (double) BLOCK_SCALE);
		blockStart = (curBlock - 1) * BLOCK_SCALE + 1;
		blockEnd = Math.min(blockStart + BLOCK_SCALE - 1, totPage);

		prevPage = (curBlock > 1) ? (blockStart - 1) : 1;
		nextPage = (blockEnd < totPage) ? (blockEnd + 1) : totPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public int getTotPage() {
		return totPage;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public int getBlockStart() {
		return blockStart;
	}

	public int getBlockEnd() {
		return blockEnd;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getCurBlock() {
		return curBlock;
	}

	public int getTotBlock() {
		return totBlock;
	}
}
